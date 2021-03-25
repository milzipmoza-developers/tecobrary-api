import React, {ReactNode} from "react";
import {useHistory} from "react-router-dom";
import "./A.css"

interface Props {
  href?: string;
  onClick?: any;
  children: ReactNode;
  disabled?: boolean;
}

const A = ({href, onClick, disabled, children}: Props) => {
  const history = useHistory();

  const _onClick = () => {
    if (!href && onClick) {
      onClick()
    }
    if (href && !onClick) {
      history.push(`${href}`);
    }
    console.debug("please check your component. at least href or onClick props need")
  }

  if (disabled) {
    return <div className="customA customA-disabled">{children}</div>
  }
  return <div className="customA" onClick={_onClick}>{children}</div>
};

export default A;