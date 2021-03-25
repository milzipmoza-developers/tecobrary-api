import {ReactNode} from "react";

interface Props {
  hide: boolean;
  children: ReactNode;
}

const Hideable = ({hide, children}: Props) => {
  return hide
    ? null
    : <div>{children}</div>;
};

export default Hideable;