import {LikeIcon} from "../icons/LikeIcon";
import {BookmarkIcon} from "../icons/BookmarkIcon";
import styled from "styled-components";
import {ReactElement} from "react";
import {useHistory} from "react-router-dom";
import React from "react";
import {CountActionButton} from "./CountActionButton";

interface Props {
  id: number
  detailButton?: boolean
  like: boolean
  likeCounts?: number
  marked: boolean
  bookMarkedCounts?: number
}

export const BookActionButtons = (props: Props): ReactElement => {
  const history = useHistory()

  const goBookDetail = () => {
    history.push(`/books/${props.id}`)
  }

  const GoDetailButton = () => (
    <>
      <TextButton onClick={goBookDetail}>자세히 알아보기</TextButton>
      <Space/>
    </>
  )

  return (
    <ActionButtonWrapper>
      { props.detailButton === undefined || props.detailButton ? <GoDetailButton/> : null}
      <CountActionButton counts={props.likeCounts}>
        <LikeIcon like={props.like}/>
      </CountActionButton>
      <Space/>
      <CountActionButton counts={props.bookMarkedCounts}>
        <BookmarkIcon marked={props.marked}/>
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
  width: 100%;
  margin-top: auto;
`

const Space = styled.div`
  width: 1rem;
`

const TextButton = styled.div`
  font-weight: bold;
  font-size: small;
  color: #2980b9;
`