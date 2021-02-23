import {routeItems} from "../routes";
import {GroupMenuItem, isGroupMenuItem, MenuItem, RouteItem} from "../interfaces/RouteItem";
import {Menu} from "antd";
import {Link} from "react-router-dom";
import React from "react";
import SubMenu from "antd/es/menu/SubMenu";

const SUB_MENU_START = 10000; // 메뉴의 고유 숫자가 겹치면 안되는데 임시방편. 좋은 방법이 있을까?

const GlobalSideMenu = () => {
  return (
    <Menu theme="dark" mode="inline" defaultSelectedKeys={["0"]}>
      {routeItems.map((value: RouteItem, index: number) => {
        if (!value.isMenu) return null;
        if (isGroupMenuItem(value)) {
          const groupMenu = value as GroupMenuItem;
          return (
            <SubMenu key={index} icon={groupMenu.icon} title={groupMenu.parentName}>
              {groupMenu.menuItems.map((item: MenuItem, innerIndex: number) => {
                return (
                  <Menu.Item key={SUB_MENU_START + innerIndex} icon={item.icon}>
                    <Link to={item.path}>
                      {item.name}
                    </Link>
                  </Menu.Item>
                )
              })}
            </SubMenu>
          );
        }
        const menu = value as MenuItem
        return (
          <Menu.Item key={index} icon={menu.icon}>
            <Link to={menu.path}>
              {menu.name}
            </Link>
          </Menu.Item>
        )
      })}
    </Menu>
  )
}

export default GlobalSideMenu;