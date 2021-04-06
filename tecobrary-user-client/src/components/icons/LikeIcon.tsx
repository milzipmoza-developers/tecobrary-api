import {ReactElement, useState} from "react";
import {Heart, HeartOutline} from "react-ionicons";

interface Props {
  like: boolean
  size?: string
}

export const LikeIcon = ({like, size}: Props): ReactElement => {
  const [filled, setFilled] = useState(like);

  const onClick = () => {
    setFilled(!filled);
  }

  return (
    <div onClick={onClick}>
      {filled
        ? <Heart color="#34495e" width={size ? size : "1.5rem"} height={size ? size : "1.5rem"}/>
        : <HeartOutline color="#34495e" width={size ? size : "1.5rem"} height={size ? size : "1.5rem"}/>}
    </div>
  )
}