import {ReactElement, useState} from "react";
import {Heart, HeartOutline} from "react-ionicons";

interface Props {
  like: boolean
}

export const LikeIcon = ({like}: Props): ReactElement => {
  const [filled, setFilled] = useState(like);

  const onClick = () => {
    setFilled(!filled);
  }

  return (
    <div onClick={onClick}>
      {filled
        ? <Heart color="#34495e" width="2rem" height="2rem"/>
        : <HeartOutline color="#34495e" width="2rem" height="2rem"/>}
    </div>
  )
}