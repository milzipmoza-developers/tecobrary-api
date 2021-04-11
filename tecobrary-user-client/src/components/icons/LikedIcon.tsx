import {ReactElement} from "react";
import {ChatboxEllipses, Heart} from "react-ionicons";

interface Props {
  color?: string
  size?: string
}

export const LikedIcon = ({color, size}: Props): ReactElement => {
  return (
    <div>
      <Heart color={color ? color : "#34495e"}
                       width={size ? size : "1.5rem"}
                       height={size ? size : "1.5rem"}/>
    </div>
  )
}