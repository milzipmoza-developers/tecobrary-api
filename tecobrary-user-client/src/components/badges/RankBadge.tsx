import React, {ReactElement} from "react";
import {KingIcon} from "../icons/Icons";
import styled from "styled-components";

interface Props {
  rank: number
}

export const RankBadge = ({rank}: Props): ReactElement => {
  const IconSelector = (): ReactElement => {
    if (rank === 1) {
      return <KingIcon size="1.5rem" color="#f1c40f"/>
    }
    if (rank === 2) {
      return <KingIcon size="1.5rem" color="#95a5a6"/>
    }
    if (rank === 3) {
      return <KingIcon size="1.5rem" color="#cd7f32"/>
    }
    return <NonIcon>{rank}</NonIcon>
  }
  return (
    <IconWrapper>
      <IconSelector/>
    </IconWrapper>
  )
}

const IconWrapper = styled.div`
  background-color: white;
  border: 1px solid #bdc3c7;
  width: 2.5rem;
  height: 2.5rem;
  border-radius: 0.5rem;
  display: flex;
  justify-content: center;
  align-items: center;
`

const NonIcon = styled.div`
  font-weight: bold;
`