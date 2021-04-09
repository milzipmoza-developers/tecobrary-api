import {ReactElement} from "react";
import {BookReviewMember} from "../../interfaces";
import styled from "styled-components";

interface Props {
  id: number
  member: BookReviewMember
  reviewType: string
  content: string
  rate: number
}

export const ReviewContent = (props: Props): ReactElement => {
  return (
    <Wrapper>
      <MemberWrapper>
        <MemberName>{props.member.name}</MemberName>
      </MemberWrapper>
      <div>{props.content}</div>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
`

const MemberWrapper = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-bottom: 0.5rem;
`

const MemberProfileImg = styled.img`
  width: 3rem;
  height: 3rem;
  border-radius: 50%;
`

const MemberName = styled.div`
  font-weight: bold;
`