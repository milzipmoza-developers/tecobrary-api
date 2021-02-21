import React, {useState} from "react";
import {Route, Switch} from "react-router-dom";
import {Layout} from "antd";
import {MenuFoldOutlined, MenuUnfoldOutlined} from "@ant-design/icons";
import GlobalAlert from "./components/GlobalAlert";
import TestFeature from "./components/TestFeature";
import GlobalSideMenu from "./components/GlobalSideMenu";
import {RouteItem} from "./interfaces/RouteItem";
import {routeItems} from "./routes";
import "./App.css";

const {Header, Sider, Content} = Layout;

function App() {
  const [collapsed, setCollapsed] = useState<boolean>(false);

  const toggle = () => {
    setCollapsed(!collapsed);
  };

  return (
    <Layout className="global-layout" style={{height: "100%"}}>
      <Sider trigger={null} collapsible collapsed={collapsed}>
        <div className="logo">테코브러리 로고</div>
        <GlobalSideMenu/>
      </Sider>
      <Layout className="site-layout">
        <Header className="site-layout-background" style={{padding: 0}}>
          {collapsed
            ? <MenuUnfoldOutlined className='trigger' onClick={toggle}/>
            : <MenuFoldOutlined className='trigger' onClick={toggle}/>}
        </Header>
        <GlobalAlert/>
        <TestFeature/>
        <Content
          className="site-layout-background"
          style={{
            margin: '24px 16px',
            padding: 24,
            minHeight: 280,
          }}
        >
          <Switch>
            {routeItems.map((value: RouteItem, index: number) => (
              <Route exact path={value.path} component={value.component} key={index}/>
            ))}
          </Switch>
        </Content>
      </Layout>
    </Layout>
  );
}

export default App;
