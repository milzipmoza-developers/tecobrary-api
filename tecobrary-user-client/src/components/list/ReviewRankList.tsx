import React, {ReactElement} from "react";
import styled from "styled-components";
import {ReviewRankElement} from "./ReviewRankElement";

interface ReviewRankItem {
  id: number
  rank: number
  name: string
  github: string
  points: number
}

const reviewRankItems: ReviewRankItem[] = [
  {
    id: 1,
    rank: 1,
    name: "개발왕루피",
    github: "thedevluffy",
    points: 1000
  },
  {
    id: 2,
    rank: 2,
    name: "탄지로",
    github: "mrkwon",
    points: 800
  },
  {
    id: 3,
    rank: 3,
    name: "젠이츠",
    github: "jenits",
    points: 300
  },
  {
    id: 4,
    rank: 4,
    name: "쿄주로",
    github: "kyojuro",
    points: 120
  },
  {
    id: 5,
    rank: 5,
    name: "상디",
    github: "sanji",
    points: 50
  },
]

function ReviewRankList(): ReactElement {
  return (
    <Wrapper>
      {reviewRankItems.map((item: ReviewRankItem, index: number) => (
        <ReviewRankElement rank={item.rank} name={item.name} point={item.points} github={item.github} key={index}/>
      ))}
    </Wrapper>
  )
}

export default ReviewRankList

const Wrapper = styled.div``

