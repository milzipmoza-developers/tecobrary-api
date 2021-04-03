import styled from "styled-components";
import React, {ReactElement} from "react";

interface Props {
  rank: number
  title: string
  author: string
  counts: number
  onClick: () => void
}


const BookRankElement = (props: Props): ReactElement => (
  <Wrapper onClick={props.onClick}>
    <RankDiv>{props.rank}</RankDiv>
    <ContentDiv>
      <TitleDiv>{props.title}</TitleDiv>
      <AuthorDiv>{props.author}</AuthorDiv>
    </ContentDiv>
    <CountDiv>{props.counts}건</CountDiv>
  </Wrapper>
)

export default BookRankElement

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  height: fit-content;
`

const RankDiv = styled.div`
  flex: 0.7;
  display: flex;
  align-items: center;
  font-weight: bold;
`

const CountDiv = styled.div`
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
`

const ContentDiv = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  margin: 0 0 0.3rem 0;
  flex: 5;
  height: 4rem;
`

const TitleDiv = styled.div`
`

const AuthorDiv = styled.div`
  font-size: small;
  color: #34495e;
  text-align: end;
`