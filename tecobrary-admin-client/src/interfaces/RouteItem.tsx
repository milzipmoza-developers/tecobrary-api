import * as React from "react";
import {ReactNode} from "react";
import {RouteComponentProps} from "react-router";

export interface RouteItem {
  isMenu: boolean;
  icon?: ReactNode;
}

export interface MenuItem extends RouteItem {
  name: string;
  path: string;
  component: React.ComponentType<RouteComponentProps<any>> | React.ComponentType<any>;
}

export interface GroupMenuItem extends RouteItem {
  parentName: string;
  menuItems: MenuItem[];
}

export type RouteMenuItem = MenuItem | GroupMenuItem;

export function isMenuItem(object: any): object is MenuItem {
  return 'name' in object;
}

export function isGroupMenuItem(object: any): object is GroupMenuItem {
  return 'parentName' in object;
}