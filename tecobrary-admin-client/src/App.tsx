import React, {useState} from "react";
import {Button, Layout, Menu} from "antd";
import {
  BookOutlined,
  CarryOutOutlined,
  DatabaseOutlined,
  MenuFoldOutlined,
  MenuUnfoldOutlined,
  UserOutlined
} from "@ant-design/icons";
import "./App.css";
import {useSetRecoilState} from "recoil";
import {alertState} from "./states/alertState";
import GlobalAlert from "./components/GlobalAlert";

const {Header, Sider, Content} = Layout;

function App() {
  const setAlert = useSetRecoilState(alertState);
  const [collapsed, setCollapsed] = useState<boolean>(false);

  const toggle = () => {
    setCollapsed(!collapsed);
  };

  const makeAlert = () => {
    setAlert({
      message: "야호",
      type: "success"
    })
  }

  return (
    <Layout className="global-layout" style={{height: "100%"}}>
      <Sider trigger={null} collapsible collapsed={collapsed}>
        <div className="logo"/>
        <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
          <Menu.Item key="1" icon={<UserOutlined/>}>
            회원관리
          </Menu.Item>
          <Menu.Item key="2" icon={<BookOutlined/>}>
            도서관리
          </Menu.Item>
          <Menu.Item key="3" icon={<DatabaseOutlined/>}>
            희망도서관리
          </Menu.Item>
          <Menu.Item key="4" icon={<CarryOutOutlined/>}>
            대여내역
          </Menu.Item>
        </Menu>
      </Sider>
      <Layout className="site-layout">
        <Header className="site-layout-background" style={{padding: 0}}>
          {collapsed
            ? <MenuUnfoldOutlined className='trigger' onClick={toggle}/>
            : <MenuFoldOutlined className='trigger' onClick={toggle}/>}
        </Header>
        <GlobalAlert/>
        <Content
          className="site-layout-background"
          style={{
            margin: '24px 16px',
            padding: 24,
            minHeight: 280,
          }}
        >
          Content
          <Button onClick={makeAlert}>얼럿</Button>
        </Content>
      </Layout>
    </Layout>
  );
}

export default App;
