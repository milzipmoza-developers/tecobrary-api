import {Button} from "antd";
import React, {ReactNode} from "react";
import {ButtonType} from "antd/lib/button/button";

interface Props {
  type?: ButtonType;
  loading?: boolean;
  danger?: boolean;
  onClick?: React.MouseEventHandler<HTMLElement>;
  children: ReactNode;
  color?: string;
}

const ColorButton = (props: Props) => (
  <Button type={props.type}
          danger={props.danger ? props.danger : false}
          loading={props.loading}
          onClick={props.onClick}
          style={props.color ? {
            backgroundColor: props.color,
            borderColor: props.color,
          } : {}}
  >
    {props.children}
  </Button>
);

export default ColorButton;