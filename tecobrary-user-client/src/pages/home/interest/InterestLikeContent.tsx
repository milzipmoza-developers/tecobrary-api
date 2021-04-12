import {ReactElement, useState} from "react";
import styled from "styled-components";
import {InterestedBook, InterestedBooks} from "../../../interfaces";
import {getInterestedBooks} from "../../../api/home";
import {LikedIcon} from "../../../components/icons/LikedIcon";
import {CardBookList} from "../../../components/list/CardBookList";

export const InterestLikeContent = (): ReactElement => {
  // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
  const [reviewBooks] = useState<InterestedBook[]>((getInterestedBooks.find((it: InterestedBooks) => it.type === 'LIKE'))!.books)

  return (
    <Wrapper>
      <CardBookList iconBadge={[<LikedIcon/>]} books={reviewBooks}/>
    </Wrapper>
  )
}


const Wrapper = styled.div`
  width: auto;
  height: fit-content;
  display: flex;
  flex-direction: column;
`