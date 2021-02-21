import {routeItems} from "../routes";
import {RouteItem} from "../interfaces/RouteItem";
import {Menu} from "antd";
import {Link} from "react-router-dom";
import React from "react";

const GlobalSideMenu = () => {
  return (
    <Menu theme="dark" mode="inline" defaultSelectedKeys={["0"]}>
      {routeItems.map((value: RouteItem, index: number) => {
        if (!value.isMenu) return null;
        return (
          <Menu.Item key={index} icon={value.icon}>
            <Link to={value.path}>
              {value.name}
            </Link>
          </Menu.Item>
        )
      })}
    </Menu>
  )
}

export default GlobalSideMenu;