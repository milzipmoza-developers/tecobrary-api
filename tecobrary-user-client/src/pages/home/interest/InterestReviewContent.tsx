import {ReactElement, useState} from "react";
import styled from "styled-components";
import {getInterestedBooks} from "../../../api/home";
import {InterestedBook, InterestedBooks} from "../../../interfaces";
import {ReviewIcon} from "../../../components/icons/ReviewIcon";
import {CardBookList} from "../../../components/list/CardBookList";

export const InterestReviewContent = (): ReactElement => {
  // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
  const [reviewBooks] = useState<InterestedBook[]>((getInterestedBooks.find((it: InterestedBooks) => it.type === 'REVIEW'))!.books)

  return (
    <Wrapper>
      <CardBookList iconBadge={[<ReviewIcon/>]} books={reviewBooks}/>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  width: auto;
  height: fit-content;
  display: flex;
  flex-direction: column;
`