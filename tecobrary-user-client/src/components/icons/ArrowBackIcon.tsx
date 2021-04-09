import {ReactElement, useState} from "react";
import {ArrowBackOutline, Heart, HeartOutline} from "react-ionicons";

interface Props {
  color?: string
  size?: string
}

export const ArrowBackIcon = ({color, size}: Props): ReactElement => {
  return (
    <div>
        <ArrowBackOutline color={color} width={size ? size : "1.5rem"} height={size ? size : "1.5rem"}/>
    </div>
  )
}