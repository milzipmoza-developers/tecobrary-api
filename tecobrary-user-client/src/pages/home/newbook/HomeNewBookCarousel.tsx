import {ReactElement} from "react";
import {NewBook} from "../../../interfaces";
import {useHistory} from "react-router-dom";
import styled from "styled-components";
import "./home.css"

interface Props {
  books: NewBook[]
}

export const HomeNewBookCarousel = ({books}: Props): ReactElement => {
  const history = useHistory()

  const onClick = (id: number) => () => {
    history.push(`/books/${id}`)
  }

  return (
    <Wrapper>
      <BookElements className='scroll-hidden'>
        {books.map((it: NewBook, index: number) => (
          <BookElement key={index} onClick={onClick(it.id)}>
            <ImageWrapper>
              <Image src={it.imageUrl}/>
            </ImageWrapper>
            <BookAuthor>{it.author}</BookAuthor>
            <BookTitle>{it.title}</BookTitle>
          </BookElement>
        ))}
      </BookElements>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  height: fit-content;
  width: auto;
  display: flex;
  flex-direction: row;
  overflow-y: hidden;
`

const BookElements = styled.div`
  overflow-y: auto;
  display: flex;
  flex-direction: row;
  width: fit-content;
  padding: 1px;
`

const BookElement = styled.div`
  display: flex;
  flex-direction: column;
  margin-right: 2rem;
  cursor: pointer;
`

const ImageWrapper = styled.div`
  height: 10rem;
  margin-bottom: 1rem;
`

const Image = styled.img`
  border-radius: 1rem;
  height: 100%;
  box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;
`

const BookAuthor = styled.div`
  font-size: small;
  font-weight: lighter;
  margin-bottom: 0.5rem;
`

const BookTitle = styled.div`
  font-size: small;
  font-weight: bold;
`
