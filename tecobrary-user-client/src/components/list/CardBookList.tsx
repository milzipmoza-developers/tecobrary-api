import {ReactElement} from "react";
import {Book, InterestedBook, ListBook} from "../../interfaces";
import {CardBookListElement} from "./CardBookListElement";
import styled from "styled-components";
import {CountedIconBadge} from "../badges/CountedIconBadge";

interface Props {
  iconBadge: ReactElement[]
  books: Book[]
}

export const CardBookList = ({iconBadge, books}: Props): ReactElement => {
  if (books.length === 0) {
    return <EmptyWrapper>텅 비어있어요</EmptyWrapper>
  }

  const conditionalCountedIconBadge = (book: Book): ReactElement => {
    if (book.hasOwnProperty('counts')) {
      return (
        <>
          <CountedIconBadge counts={(book as InterestedBook).counts}>
            {iconBadge[0]}
          </CountedIconBadge>
        </>
      )
    }

    if (book.hasOwnProperty('countDetail')) {
      const aBook = book as ListBook
      return (<IconWrapper>
        <CountedIconBadge counts={aBook.countDetail.review}>
          {iconBadge[0]}
        </CountedIconBadge>
        <CountedIconBadge counts={aBook.countDetail.like}>
          {iconBadge[1]}
        </CountedIconBadge>
        <CountedIconBadge counts={aBook.countDetail.bookMarked}>
          {iconBadge[2]}
        </CountedIconBadge>
      </IconWrapper>)
    }

    return <></>
  }

  return (<>
    {books.map((book: Book, index: number) => (
      <CardBookListElement {...book} key={index} iconBadge={conditionalCountedIconBadge(book)}/>))}
  </>)
};

const EmptyWrapper = styled.div`
  display: flex;
  width: auto;
  height: 8rem;
  justify-content: center;
  align-items: center;
`

const IconWrapper = styled.div`
  display: flex;
  flex-direction: row;
`