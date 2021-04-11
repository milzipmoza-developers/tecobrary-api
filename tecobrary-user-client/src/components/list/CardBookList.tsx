import {ReactElement} from "react";
import {InterestedBook} from "../../interfaces";
import {CardBookListElement} from "./CardBookListElement";
import styled from "styled-components";

interface Props {
  iconBadge: ReactElement
  reviewBooks: InterestedBook[]
}

export const CardBookList = ({iconBadge, reviewBooks}: Props): ReactElement => {
  if (reviewBooks.length === 0) {
    return <EmptyWrapper>텅 비어있어요</EmptyWrapper>
  }

  return (<>
    {reviewBooks.map((book: InterestedBook, index: number) => (
      <CardBookListElement {...book} key={index} iconBadge={iconBadge}/>))}
  </>)
}

const EmptyWrapper = styled.div`
  display: flex;
  width: auto;
  height: 8rem;
  justify-content: center;
  align-items: center;
`