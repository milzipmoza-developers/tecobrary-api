import React, {ReactElement} from "react";
import {CategoryBadges} from "../../components/badges/CategoryBadges";
import {parseDate} from "../../utils/date";
import {BookDetailActionButtons} from "./BookDetailActionButtons";
import styled from "styled-components";
import {BookLike, BookMarked, BookTechDetail, Category} from "../../interfaces";

interface Props {
  id: number
  imageUrl: string
  title: string
  author: string
  publisher: string
  description: string
  publishDate: string
  categories: Category[]
  like: BookLike
  bookMark: BookMarked
  techDetail?: BookTechDetail
}

function BookDetailCard(props: Props): ReactElement {
  return (
    <Wrapper>
      <ImageWrapper>
        <Image src={props.imageUrl}/>
      </ImageWrapper>
      <BookDetailWrapper>
        <BookTitleWrapper>{props.title}</BookTitleWrapper>
        <CategoryBadges categories={props.categories}/>
        <BookPublishInfoWrapper>
          <div>{props.publisher}</div>
          <div>{props.author}</div>
        </BookPublishInfoWrapper>
        <BookSubInfoWrapper>
          <div style={{fontWeight: "lighter"}}>출판일 {parseDate(props.publishDate)}</div>
          <BookDetailActionButtons id={props.id}
                                   like={props.like.liked}
                                   likeCounts={props.like.counts}
                                   marked={props.bookMark.marked}
                                   bookMarkedCounts={props.bookMark.counts}/>
        </BookSubInfoWrapper>
        <BookDescriptionWrapper>
          {props.description}
        </BookDescriptionWrapper>
      </BookDetailWrapper>
    </Wrapper>
  )
}

export default BookDetailCard

const Wrapper = styled.div`
  position: relative;
  top: 13rem;
  width: auto;
  height: fit-content;
  background-color: #1E1E1E;
  color: white;
  border-radius: 2rem;
  padding: 1rem;
`

const ImageWrapper = styled.div`
  position: relative;
  width: auto;
  display: flex;
  flex-direction: row;
  justify-content: center;
  height: 12.5rem;
  transform: translate3d(0, -50%, 0);
  border-radius: 1rem;
  margin-bottom: -3.5rem;
`

const Image = styled.img`
  border-radius: 1rem;
  height: 100%;
  box-shadow: rgba(0, 0, 0, 0.15) 2.4px 2.4px 3.2px;
`

const BookDetailWrapper = styled.div`
  position: relative;
  width: auto;
  height: fit-content;
  display: flex;
  flex-direction: column;
`

const BookTitleWrapper = styled.div`
  width: auto;
  font-weight: bold;
  font-size: 1.5em;
  text-align: center;
`

const BookPublishInfoWrapper = styled.div`
  text-align: center;
  margin: 0 0 1rem 0;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
`

const BookSubInfoWrapper = styled.div`
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
`

const BookDescriptionWrapper = styled.div`
  font-weight: lighter;
  font-size: small;
  margin: 2rem 1rem 0 1rem;
`
