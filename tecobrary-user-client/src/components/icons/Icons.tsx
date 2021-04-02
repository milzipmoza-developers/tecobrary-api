import {ReactElement} from "react";
import {ReactComponent as ReactLogo} from '../../assets/king.svg';

interface Props {
  size: string
  color: string
}


export const KingIcon = ({size, color}: Props): ReactElement => (
  <ReactLogo style={{width: `${size}`, height: `${size}`, fill: `${color}`, stroke: `${color}`}}/>
)
