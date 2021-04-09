import React, {ReactElement, useState} from "react";
import PageFrame from "../components/page/PageFrame";
import {PageContent} from "../components/page/PageContent";
import Card from "../components/card/Card";
import Plain from "../components/plain/Plain";
import {BookDetail, BookReview} from "../interfaces";
import {getBookDetail, getBookReviews} from "../api/bookDetail";
import {useParams} from "react-router-dom";
import {BookDetailContent} from "../components/plain/BookDetailContent";
import {ReviewContent} from "../components/card/ReviewContent";
import styled from "styled-components";

interface Params {
  id?: string | undefined
}

function BookPage(): ReactElement {
  const {id} = useParams<Params>()
  // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
  const [bookDetail] = useState<BookDetail>(getBookDetail.get(Number.parseInt(id!)) ? getBookDetail.get(Number.parseInt(id!))! : getBookDetail.get(1)! )
  const [bookReviews] = useState<BookReview[]>(getBookReviews)

  console.log('book id', id) // todo: remove

  return (
    <PageFrame title="도서 상세">
      <PageContent>
        <Plain title={bookDetail.title}>
          <BookDetailContent {...bookDetail}/>
        </Plain>
      </PageContent>
      <PageContent>
        <Plain title="리뷰를 살펴보세요">
          {bookReviews.map((it: BookReview, index: number) => (
            <CardWrapper key={index}>
              <Card backgroundColor="#E0FEFE">
                <ReviewContent {...it}/>
              </Card>
            </CardWrapper>
          ))}
        </Plain>
      </PageContent>
    </PageFrame>
  )
}

export default BookPage

const CardWrapper = styled.div`
  margin-bottom: 1rem;
`
