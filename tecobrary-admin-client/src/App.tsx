import React, {useState} from "react";
import {Button, Layout, Menu} from "antd";
import {
  MenuFoldOutlined,
  MenuUnfoldOutlined,
  UploadOutlined,
  UserOutlined,
  VideoCameraOutlined,
} from "@ant-design/icons";
import "./App.css";

const {Header, Sider, Content} = Layout;

function App() {
  const [collapsed, setCollased] = useState<boolean>(false);

  const toggle = () => {
    setCollased(!collapsed);
  };

  return (
    <Layout className="global-layout" style={{height: "100%"}}>
      <Sider trigger={null} collapsible collapsed={collapsed}>
        <div className="logo"/>
        <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
          <Menu.Item key="1" icon={<UserOutlined/>}>
            nav 1
          </Menu.Item>
          <Menu.Item key="2" icon={<VideoCameraOutlined/>}>
            nav 2
          </Menu.Item>
          <Menu.Item key="3" icon={<UploadOutlined/>}>
            nav 3
          </Menu.Item>
        </Menu>
      </Sider>
      <Layout className="site-layout">
        <Header className="site-layout-background" style={{padding: 0}}>
          {collapsed
            ? <MenuUnfoldOutlined className='trigger' onClick={toggle}/>
            : <MenuFoldOutlined className='trigger' onClick={toggle}/>}
        </Header>
        <Content
          className="site-layout-background"
          style={{
            margin: '24px 16px',
            padding: 24,
            minHeight: 280,
          }}
        >
          Content
          <Button type="primary">Button</Button>
        </Content>
      </Layout>
    </Layout>
  );
}

export default App;
