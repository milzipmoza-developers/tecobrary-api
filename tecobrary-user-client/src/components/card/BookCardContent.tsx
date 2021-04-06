import React, {ReactElement} from "react";
import {CategoryBadges} from "../badges/CategoryBadges";
import {BookActionButtons} from "../buttons/BookActionButtons";
import styled from "styled-components";
import {BookLike, BookMarked, Category} from "../../interfaces";

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

export const BookCardContent = (props: Props): ReactElement => {
  return (
    <Wrapper>
      <BookDetail>
        <BookDetailImage>
          <img src={props.imageUrl} width="100%"/>
        </BookDetailImage>
        <BookDetailContent>
          <CategoryBadges categories={props.categories}/>
          <div>{props.author}</div>
          <div>{props.publisher}</div>
          <BookActionButtons id={props.id}
                             like={props.like.liked}
                             likeCounts={props.like.counts}
                             marked={props.bookMark.marked}
                             bookMarkedCounts={props.bookMark.counts}
                             detailButton={false}/>
        </BookDetailContent>
      </BookDetail>
      <BookDescription>{props.description}</BookDescription>
    </Wrapper>
  )
}


const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  height: fit-content;
  width: 100%;
`

const BookDetail = styled.div`
  display: flex;
  flex-direction: row;
  height: fit-content;
  width: 100%;
`

const BookDetailImage = styled.div`
  display: flex;
  flex: 1.2;
`

const BookDetailContent = styled.div`
  display: flex;
  flex: 3;
  flex-direction: column;
`

const BookDescription = styled.div`
  margin-top: 1rem;
  background-color: #ecf0f1;
  padding: 1rem;
  border-radius: 1.5rem;
`
