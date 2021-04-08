import React, {ReactElement} from "react";
import {CategoryBadges} from "../badges/CategoryBadges";
import {BookActionButtons} from "../buttons/BookActionButtons";
import styled from "styled-components";
import {BookLike, BookMarked, Category} from "../../interfaces";
import {FoldableCard} from "../card/FoldableCard";

interface Props {
  id: number
  imageUrl: string
  title: string
  author: string
  publisher: string
  description: string
  categories: Category[]
  like: BookLike
  bookMark: BookMarked
}

export const BookDetailContent = (props: Props): ReactElement => {
  return (
    <Wrapper>
      <Detail>
        <BookImage>
          <img src={props.imageUrl} width="100%"/>
        </BookImage>
        <BookContent>
          <CategoryBadges categories={props.categories}/>
          <div>{props.author}</div>
          <div>{props.publisher}</div>
          <BookActionButtons id={props.id}
                             like={props.like.liked}
                             likeCounts={props.like.counts}
                             marked={props.bookMark.marked}
                             bookMarkedCounts={props.bookMark.counts}
                             detailButton={false}/>
        </BookContent>
      </Detail>
      <FoldableCard backgroundColor="#ecf0f1">
        <div>{props.description}</div>
      </FoldableCard>
    </Wrapper>
  )
}


const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  height: fit-content;
  width: 100%;
`

const Detail = styled.div`
  display: flex;
  flex-direction: row;
  height: fit-content;
  width: 100%;
`

const BookImage = styled.div`
  display: flex;
  flex: 1.2;
`

const BookContent = styled.div`
  display: flex;
  flex: 3;
  flex-direction: column;
`
