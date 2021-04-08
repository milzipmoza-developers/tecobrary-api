import {CategoryBadges} from "../badges/CategoryBadges";
import {BookActionButtons} from "../buttons/BookActionButtons";
import React, {ReactElement} from "react";
import styled from "styled-components";
import {BookLike, BookMarked, Category} from "../../interfaces";

interface Props {
  id: number
  imageUrl: string
  title: string
  author: string
  publisher: string
  publishDate: string
  description: string
  categories: Category[]
  like: BookLike
  bookMark: BookMarked
}

export const BookDetail = (props: Props): ReactElement => {
  return (
    <Wrapper>
      <BookImage>
        <img src={props.imageUrl} width="100%"/>
      </BookImage>
      <BookContent>
        <CategoryBadges categories={props.categories}/>
        <div>{props.author}</div>
        <div>{props.publisher}</div>
        <div>{props.publishDate}</div>
        <BookActionButtons id={props.id}
                           like={props.like.liked}
                           likeCounts={props.like.counts}
                           marked={props.bookMark.marked}
                           bookMarkedCounts={props.bookMark.counts}
                           detailButton={false}/>
      </BookContent>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  height: fit-content;
  width: 100%;
  margin-bottom: 1rem;
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