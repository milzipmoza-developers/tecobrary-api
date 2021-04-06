import {ReactElement, useState} from "react";
import {Bookmark, BookmarkOutline, Heart} from "react-ionicons";

interface Props {
  marked: boolean
  size?: string
}

export const BookmarkIcon = ({marked, size}: Props): ReactElement => {
  const [filled, setFilled] = useState(marked);

  const onClick = () => {
    setFilled(!filled);
  }

  return (
    <div onClick={onClick}>
      {filled
        ? <Bookmark color="#34495e" width={size ? size : "1.5rem"} height={size ? size : "1.5rem"}/>
        : <BookmarkOutline color="#34495e" width={size ? size : "1.5rem"} height={size ? size : "1.5rem"}/>}
    </div>
  )
}