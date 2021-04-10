import React, {ReactElement} from "react";
import {CategoryBadges} from "../../components/badges/CategoryBadges";
import {parseDate} from "../../utils/date";
import {BookDetailActionButtons} from "./BookDetailActionButtons";
import styled from "styled-components";
import {BookLike, BookMarked, BookTechDetail, Category} from "../../interfaces";
import Plain from "../../components/plain/Plain";

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

  const BookPublishInfo = () => (
    <BookPublishInfoWrapper>
      <div>{props.publisher}</div>
      <div>{props.author}</div>
    </BookPublishInfoWrapper>
  )

  const BookSubInfo = () => (
    <BookSubInfoWrapper>
      <BookPublishDateWrapper>출판일 {parseDate(props.publishDate)}</BookPublishDateWrapper>
      <BookDetailActionButtons id={props.id}
                               like={props.like.liked}
                               likeCounts={props.like.counts}
                               marked={props.bookMark.marked}
                               bookMarkedCounts={props.bookMark.counts}/>
    </BookSubInfoWrapper>
  )

  const BookTechInfo = () => (
    props.techDetail
      ? (
        <Plain title='이런 기술을 다뤄요' margin="0 0 2rem 0">
          <div style={{marginLeft: '0.5rem', fontWeight: 'lighter'}}>
            주로 <b>{props.techDetail?.mainTech}</b> <b>{props.techDetail?.mainVersion}</b> 버전을 다뤄요
          </div>
          <div style={{marginLeft: '0.5rem', fontWeight: 'lighter'}}>
            추가로 <b>{props.techDetail?.additionalTech}</b> 도 다루고 있어요
          </div>
          <div style={{marginLeft: '0.5rem', fontWeight: 'lighter'}}>
            버전과의 의존성은 {props.techDetail?.versionDependency}
          </div>
        </Plain>
      )
      : null
  )

  return (
    <Wrapper>
      <ImageWrapper>
        <Image src={props.imageUrl}/>
      </ImageWrapper>
      <BookDetailWrapper>
        <BookTitleWrapper>{props.title}</BookTitleWrapper>
        <CategoryBadges categories={props.categories}/>
        <BookPublishInfo/>
        <BookSubInfo/>
        <BookDescriptionWrapper>
          {props.description}
        </BookDescriptionWrapper>
      </BookDetailWrapper>
      <BookTechInfo/>
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
  margin-bottom: 13rem; // top 13rem
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

const BookPublishDateWrapper = styled.div`
  font-weight: lighter;
`

const BookDescriptionWrapper = styled.div`
  font-weight: lighter;
  font-size: small;
  margin: 2rem 1rem 2rem 1rem;
`
