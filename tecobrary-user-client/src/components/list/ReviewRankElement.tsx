import React, {ReactElement} from "react";
import {RankBadge} from "../badges/RankBadge";
import styled from "styled-components";

interface Props {
  rank: number
  name: string
  point: number
  github: string
}

export const ReviewRankElement = (props: Props): ReactElement => {

  const onClick = (): void => {
    window.open(`https://github.com/${props.github}`, '_blank')
  }

  return (
    <Wrapper onClick={onClick}>
      <RankBadge rank={props.rank}/>
      <ReviewRankContent>
        <ReviewRankName>
          {props.name}
        </ReviewRankName>
        <ReviewRankPoint>
          {props.point}P
        </ReviewRankPoint>
      </ReviewRankContent>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  margin: 1rem 0 1rem 0;
  width: auto;
`

const ReviewRankContent = styled.div`
  display: flex;
  flex-direction: row;
  width: 100%;
  justify-content: center;
  align-items: center;
`

const ReviewRankName = styled.div`
  flex: 2;
  text-align: center;
  font-weight: bold;
`

const ReviewRankPoint = styled.div`
  flex: 1;
  text-align: center;
`