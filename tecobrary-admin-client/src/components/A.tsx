import React, {ReactNode} from "react";
import {useHistory} from "react-router-dom";
import "./A.css"

interface Props {
  href?: string;
  onClick?: any;
  children: ReactNode;
}

const A = ({href, onClick, children}: Props) => {
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

  return (
    <div className="customA" onClick={_onClick}>{children}</div>
  )
}

export default A;