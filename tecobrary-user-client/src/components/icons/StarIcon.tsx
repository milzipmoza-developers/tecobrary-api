import {ReactElement} from "react";
import {Star, StarOutline} from "react-ionicons";

interface Props {
  filled: boolean
  color?: string
  size?: string
}

export const StarIcon = ({filled, color, size}: Props): ReactElement => {
  return <div>
    {filled
      ? <Star color={color} width={size ? size : "1.5rem"} height={size ? size : "1.5rem"}/>
      : <StarOutline color={color} width={size ? size : "1.5rem"} height={size ? size : "1.5rem"}/>}
  </div>
}