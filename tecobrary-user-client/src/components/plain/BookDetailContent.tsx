import React, {ReactElement} from "react";
import {CategoryBadges} from "../badges/CategoryBadges";
import {BookActionButtons} from "../buttons/BookActionButtons";
import styled from "styled-components";
import {BookLike, BookMarked, BookTechDetail, Category} from "../../interfaces";
import {FoldableCard} from "../card/FoldableCard";
import Plain from "./Plain";
import {BookDetail} from "./BookDetail";

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
  techDetail?: BookTechDetail
}

export const BookDetailContent = (props: Props): ReactElement => {
  return (
    <Wrapper>
      <BookDetail {...props}/>
      {props.techDetail ? <Plain title="이런 기술을 다뤄요">
        <TechDetailRow>
          <div>주로</div>
          <div>{props.techDetail?.mainTech}</div>
        </TechDetailRow>
        <TechDetailRow>
          <div>추가로</div>
          <div>{props.techDetail?.additionalTech}</div>
        </TechDetailRow>
        <TechDetailRow>
          <div>버전은</div>
          <div>{props.techDetail?.mainVersion}</div>
        </TechDetailRow>
        <TechDetailRow>
          <div>버전과 강한 의존성</div>
          <div>{props.techDetail?.versionDependency}</div>
        </TechDetailRow>
      </Plain> : null}
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

const TechDetailRow = styled.div`
  width: auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
`