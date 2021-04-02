import React, {ReactElement} from "react";
import styled from "styled-components";
import BookRankElement from "./BookRankElement";
import {useHistory} from "react-router-dom";

const Wrapper = styled.div`
  height: fit-content;
  width: auto;
  margin-left: 0.5rem;
  margin-right: 0.5rem;
  display: flex;
  flex-direction: column;
`

interface RankListItem {
  id: number
  rank: number
  title: string
  author: string
  counts: number
}

const listItems: RankListItem[] = [
  {
    id: 1,
    rank: 1,
    title: '객체지향의 사실과 오해',
    author: '조영호',
    counts: 10
  },
  {
    id: 1,
    rank: 2,
    title: '데이터베이스 인터널스',
    author: '알렉스 페트로프',
    counts: 9
  },
  {
    id: 1,
    rank: 3,
    title: '이것이 레디스다',
    author: '강대명',
    counts: 7
  },
  {
    id: 1,
    rank: 4,
    title: '빅 데이터 세상으로 떠나는 간결한 안내서 NoSQL',
    author: '마틴 파울러',
    counts: 5
  },
  {
    id: 1,
    rank: 5,
    title: '성공과 실패를 결정하는 1%의 네트워크 원리',
    author: 'Tsutomu Tone',
    counts: 3
  },
]


function BookRankList(): ReactElement {
  const history = useHistory();

  return (
    <Wrapper>
      {listItems.map((item: RankListItem, index: number) =>
        <BookRankElement
          rank={item.rank}
          title={item.title}
          author={item.author}
          counts={item.counts}
          key={index}
          onClick={() => history.push(`/books/${item.id}`)}/>
      )}
    </Wrapper>
  )
}

export default BookRankList