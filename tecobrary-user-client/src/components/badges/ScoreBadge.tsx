import {ReactElement} from "react";
import styled from "styled-components";
import {StarIcon} from "../icons/StarIcon";

interface Props {
  rate: number
}

export const ScoreBadge = ({rate}: Props): ReactElement => {
  return (
    <Wrapper>
      {[1, 2, 3, 4, 5].map((value: number, index: number) => {
        if (value <= rate) return <StarIcon color='black' filled={true} key={index} size='1rem'/>
        return <StarIcon color='black' filled={false} key={index} size='1rem'/>
      })}
    </Wrapper>
  )
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
`