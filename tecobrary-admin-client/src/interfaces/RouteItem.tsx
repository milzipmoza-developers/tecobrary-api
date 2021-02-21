import {ReactNode} from "react";
import * as React from "react";
import {RouteComponentProps} from "react-router";

export interface RouteItem {
  isMenu: boolean,
  icon: ReactNode | null,
  name: string,
  path: string,
  component: React.ComponentType<RouteComponentProps<any>> | React.ComponentType<any>
}