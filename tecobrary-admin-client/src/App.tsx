import React, {useState} from "react";
import {Route, Switch} from "react-router-dom";
import {Layout} from "antd";
import {MenuFoldOutlined, MenuUnfoldOutlined} from "@ant-design/icons";
import GlobalAlert from "./components/GlobalAlert";
import TestFeature from "./components/TestFeature";
import GlobalSideMenu from "./components/GlobalSideMenu";
import {GroupMenuItem, isGroupMenuItem, isMenuItem, MenuItem, RouteItem} from "./interfaces/RouteItem";
import {routeItems} from "./routes";
import "./App.css";

const {Header, Sider, Content} = Layout;

function App() {
  const [collapsed, setCollapsed] = useState<boolean>(false);

  const toggle = () => {
    setCollapsed(!collapsed);
  };

  return (
    <Layout className="global-layout" style={{height: "100%", overflow: "hidden"}}>
      <Sider trigger={null} collapsible collapsed={collapsed}>
        <div className="logo">테코브러리 로고</div>
        <GlobalSideMenu/>
      </Sider>
      <Layout className="site-layout">
        <Header className="site-layout-background" style={{padding: 0}}>
          {collapsed
            ? <MenuUnfoldOutlined className='trigger' onClick={toggle}/>
            : <MenuFoldOutlined className='trigger' onClick={toggle}/>}
          <TestFeature/>
        </Header>
        <GlobalAlert/>
        <Content
          className="site-layout-background"
          style={{
            margin: '24px 16px',
            padding: 24,
            minHeight: 280,
            overflow: 'auto'
          }}
        >
          <Switch>
            {routeItems.map((value: RouteItem, index: number) => {
              if (isMenuItem(value)) {
                const menu = value as MenuItem
                return <Route exact path={menu.path} component={menu.component} key={index}/>
              }
              if (isGroupMenuItem(value)) {
                const menu = value as GroupMenuItem
                return menu.menuItems.map((item: MenuItem, innerIndex: number) => {
                  return <Route exact path={item.path} component={item.component} key={10000 + innerIndex}/>
                });
              }
              return null;
            })}
          </Switch>
        </Content>
      </Layout>
    </Layout>
  );
}

export default App;
