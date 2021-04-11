import {ReactElement, useState} from "react";
import styled from "styled-components";
import {getInterestedBooks} from "../../../api/home";
import {InterestedBook, InterestedBooks} from "../../../interfaces";
import {CardBookListElement} from "../../../components/list/CardBookListElement";
import {ReviewIcon} from "../../../components/icons/ReviewIcon";
import {CardBookList} from "../../../components/list/CardBookList";
import {LikedIcon} from "../../../components/icons/LikedIcon";

export const InterestReviewContent = (): ReactElement => {
  // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
  const [reviewBooks] = useState<InterestedBook[]>((getInterestedBooks.find((it: InterestedBooks) => it.type === 'REVIEW'))!.books)

  return (
    <Wrapper>
      <CardBookList iconBadge={<ReviewIcon/>} reviewBooks={reviewBooks}/>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  width: auto;
  height: fit-content;
  display: flex;
  flex-direction: column;
`