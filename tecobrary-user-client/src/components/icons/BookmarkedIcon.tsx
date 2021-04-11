import {ReactElement} from "react";
import {Bookmark, ChatboxEllipses, Heart} from "react-ionicons";

interface Props {
  color?: string
  size?: string
}

export const BookmarkedIcon = ({color, size}: Props): ReactElement => {
  return (
    <div>
      <Bookmark color={color ? color : "#34495e"}
                width={size ? size : "1.5rem"}
                height={size ? size : "1.5rem"}/>
    </div>
  )
}