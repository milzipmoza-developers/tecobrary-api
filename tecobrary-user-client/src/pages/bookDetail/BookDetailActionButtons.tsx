import {LikeIcon} from "../../components/icons/LikeIcon";
import {BookmarkIcon} from "../../components/icons/BookmarkIcon";
import styled from "styled-components";
import {ReactElement} from "react";
import {useHistory} from "react-router-dom";
import React from "react";
import {CountActionButton} from "../../components/buttons/CountActionButton";

interface Props {
  id: number
  like: boolean
  likeCounts?: number
  marked: boolean
  bookMarkedCounts?: number
}

export const BookDetailActionButtons = (props: Props): ReactElement => {
  return (
    <ActionButtonWrapper>
      <CountActionButton counts={props.likeCounts} color="white">
        <LikeIcon like={props.like} color="white"/>
      </CountActionButton>
      <Space/>
      <CountActionButton counts={props.bookMarkedCounts} color="white">
        <BookmarkIcon marked={props.marked} color="white"/>
      </CountActionButton>
    </ActionButtonWrapper>
  )
}

const ActionButtonWrapper = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  align-self: baseline;
  align-items: center;
`

const Space = styled.div`
  width: 1rem;
`