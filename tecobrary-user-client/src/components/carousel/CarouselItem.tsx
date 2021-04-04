import {ReactElement} from "react";
import {CategoryBadges} from "../badges/CategoryBadges";
import {BookActionButtons} from "./BookActionButtons";
import styled from "styled-components";
import {Category} from "../../interfaces";

interface Props {
  id: number
  imageUrl: string
  title: string
  author: string
  publisher: string
  description: string
  categories: Category[]
  like: boolean
  bookMarked: boolean
}

function CarouselItem(props: Props): ReactElement {
  return (
    <Wrapper>
      <ImageWrapper>
        <img src={props.imageUrl} height="100%" alt={props.title}/>
      </ImageWrapper>
      <ContentWrapper>
        <ContentTitle>{props.title}</ContentTitle>
        <CategoryBadges categories={props.categories}/>
        <ContentRow>
          <ContentText>{props.author}</ContentText>
          <Space/>
          <ContentText>{props.publisher}</ContentText>
        </ContentRow>
        <ContentDescription>{props.description}</ContentDescription>
        <BookActionButtons id={props.id} like={props.like} marked={props.bookMarked}/>
      </ContentWrapper>
    </Wrapper>
  )
}

export default CarouselItem

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  width: 34rem;
  height: 20vh;
  max-height: 14rem;
  background-color: #00000011;
  margin: 0 1rem 0 1rem;
`

const ImageWrapper = styled.div`
  flex: 1;
  display: flex;
  height: 100%;
  justify-content: center;
  align-items: center;
`

const ContentWrapper = styled.div`
  flex: 3;
  padding: 1rem;
  display: flex;
  flex-direction: column;
`

const ContentTitle = styled.div`
  font-size: large;
  font-weight: bold;
`

const ContentText = styled.div`

`

const ContentDescription = styled.div`
  font-size: 0.9em;
  height: 3.6em;
  overflow: hidden;
`

const ContentRow = styled.div`
  display: flex;
  flex-direction: row;
  margin-bottom: 0.5rem;
  justify-content: flex-end;
`

const Space = styled.div`
  width: 1rem;
`