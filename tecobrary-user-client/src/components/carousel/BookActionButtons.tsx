import {LikeIcon} from "../icons/LikeIcon";
import {BookmarkIcon} from "../icons/BookmarkIcon";
import styled from "styled-components";
import {ReactElement} from "react";
import {useHistory} from "react-router-dom";

interface Props {
  id: number
  like: boolean
  marked: boolean
}

export const BookActionButtons = ({id, like, marked}: Props): ReactElement => {
  const history = useHistory()

  const goBookDetail = () => {
    history.push(`/books/${id}`)
  }

  return (
    <ActionButtonWrapper>
      <TextButton onClick={goBookDetail}>자세히 알아보기</TextButton>
      <Space/>
      <LikeIcon like={like}/>
      <Space/>
      <BookmarkIcon marked={marked}/>
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
  width: 2rem;
`

const TextButton = styled.div`
  font-weight: bold;
  font-size: small;
  color: #2980b9;
`