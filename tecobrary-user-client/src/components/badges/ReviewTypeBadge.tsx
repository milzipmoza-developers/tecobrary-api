import {ReactElement} from "react";
import styled from "styled-components";

interface Props {
  type: 'SHORT_REVIEW' | 'BLOG_IMPORT'
  link?: string
}

export const ReviewTypeBadge = ({type, link}: Props): ReactElement | null => {

  const onClick = () => {
    window.open(link);
  }

  if (type === 'SHORT_REVIEW') {
    return <Wrapper style={{backgroundColor: 'black'}}>
      <BadgeText style={{fontWeight: 'bold', fontSize: 'small', color: 'white'}}>
        한 줄 리뷰
      </BadgeText>
    </Wrapper>
  }
  if (type === 'BLOG_IMPORT') {
    return <Wrapper style={{backgroundColor: '#2F6CD6', cursor: 'pointer'}} onClick={onClick}>
      <BadgeText style={{fontWeight: 'bold', fontSize: 'small', color: 'white'}}>
        블로그 리뷰
      </BadgeText>
    </Wrapper>
  }
  return null
}

const Wrapper = styled.span`
  height: fit-content;
  width: fit-content;
  padding: 2px 4px 2px 4px;
  margin: 0 4px 0 4px;
  border-radius: 0.3rem;
  display: flex;
  justify-content: center;
  align-items: center;
`

const BadgeText = styled.a`
  width: fit-content;
  height: fit-content;
  font-size: small;
  color: black;
`
