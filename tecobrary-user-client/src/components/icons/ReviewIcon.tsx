import {ReactElement} from "react";
import {ChatboxEllipses, Heart} from "react-ionicons";

interface Props {
  color?: string
  size?: string
}

export const ReviewIcon = ({color, size}: Props): ReactElement => {
  return (
    <div>
      <ChatboxEllipses color={color ? color : "#34495e"}
                       width={size ? size : "1.5rem"}
                       height={size ? size : "1.5rem"}/>
    </div>
  )
}