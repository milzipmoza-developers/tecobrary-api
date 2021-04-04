import {ReactElement, useState} from "react";
import {Bookmark, BookmarkOutline} from "react-ionicons";

interface Props {
  marked: boolean
}

export const BookmarkIcon = ({marked}: Props): ReactElement => {
  const [filled, setFilled] = useState(marked);

  const onClick = () => {
    setFilled(!filled);
  }

  return (
    <div onClick={onClick}>
      {filled
        ? <Bookmark color="#34495e" width="2rem" height="2rem"/>
        : <BookmarkOutline color="#34495e" width="2rem" height="2rem"/>}
    </div>
  )
}