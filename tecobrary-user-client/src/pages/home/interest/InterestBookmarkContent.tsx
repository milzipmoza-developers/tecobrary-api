import {ReactElement, useState} from "react";
import styled from "styled-components";
import {InterestedBook, InterestedBooks} from "../../../interfaces";
import {getInterestedBooks} from "../../../api/home";
import {BookmarkedIcon} from "../../../components/icons/BookmarkedIcon";
import {CardBookList} from "../../../components/list/CardBookList";

export const InterestBookmarkContent = (): ReactElement => {
  // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
  const [reviewBooks] = useState<InterestedBook[]>((getInterestedBooks.find((it: InterestedBooks) => it.type === 'BOOK_MARKED'))!.books)

  return (
    <Wrapper>
      <CardBookList iconBadge={<BookmarkedIcon/>} reviewBooks={reviewBooks}/>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  width: auto;
  height: fit-content;
  display: flex;
  flex-direction: column;
`