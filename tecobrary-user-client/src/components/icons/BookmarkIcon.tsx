import {ReactElement, useState} from "react";
import {Bookmark, BookmarkOutline, Heart} from "react-ionicons";

interface Props {
  color?: string
  marked: boolean
  size?: string
}

export const BookmarkIcon = ({color, marked, size}: Props): ReactElement => {
  const [filled, setFilled] = useState(marked);

  const onClick = () => {
    setFilled(!filled);
  }

  return (
    <div onClick={onClick}>
      {filled
        ? <Bookmark color={color ? color : "#34495e"} width={size ? size : "1.5rem"} height={size ? size : "1.5rem"}/>
        : <BookmarkOutline color={color ? color : "#34495e"} width={size ? size : "1.5rem"} height={size ? size : "1.5rem"}/>}
    </div>
  )
}