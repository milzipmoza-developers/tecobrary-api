import {ReactElement, useState} from "react";
import styled from "styled-components";
import "./carousel.css"
import {NewBook} from "../../interfaces";
import {getNewArrivalBooks} from "../../api/home";
import CarouselItem from "./CarouselItem";

// todo: screen size & auto scroll
function NewBookCarousel(): ReactElement {

  const [newArrivalBooks] = useState<NewBook[]>(getNewArrivalBooks)

  return (
    <Wrapper className="carousel-wrapper">
      <CarouselItems>
        {newArrivalBooks.map((it: NewBook, index: number) => (<CarouselItem {...it} key={index}/>))}
      </CarouselItems>
    </Wrapper>
  )
}

export default NewBookCarousel

const Wrapper = styled.div`
  height: fit-content;
  background-color: rgba(0, 0, 0, 0);
  margin-left: -2.5rem;
  overflow-y: hidden;
  position: static;
  display: inline-block;
  width: 36rem;
`

const CarouselItems = styled.div`
  overflow-y: auto;
  display: flex;
  flex-direction: row;
  width: fit-content;
`
