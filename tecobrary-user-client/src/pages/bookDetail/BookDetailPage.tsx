import React, {ReactElement, useState} from "react";
import {useParams} from "react-router-dom";
import {BookDetail, BookDetailReview} from "../../interfaces";
import {getBookDetail, getBookDetailReview} from "../../api/bookDetail";
import {PageFrame} from "../../components/page/PageFrame";
import BookDetailCard from "./BookDetailCard";
import Plain from "../../components/plain/Plain";
import {PageContent} from "../../components/page/PageContent";
import BookReviewCard from "./BookReviewCard";

interface Params {
  bookId?: string
}

function BookDetailPage(): ReactElement {
  const {bookId} = useParams<Params>()
  // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
  const [bookDetail] = useState<BookDetail>(getBookDetail.get(Number.parseInt(bookId!)) ? getBookDetail.get(Number.parseInt(bookId!))! : getBookDetail.get(1)!)
  // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
  const [bookDetailReview] = useState<BookDetailReview>(getBookDetailReview(Number.parseInt(bookId!) % 2 === 0 ? 3 : 6))

  return (
    <PageFrame header={true}>
      <PageContent style={{marginBottom: '2rem'}}>
        <BookDetailCard {...bookDetail}/>
      </PageContent>
      <PageContent style={{marginBottom: '2rem', marginTop: '15rem'}}>
        <Plain title='리뷰를 확인해보세요' margin='0 1rem 0 1rem'>
          <BookReviewCard bookId={bookId}
                          reviews={bookDetailReview.reviews}
                          counts={bookDetailReview.counts}/>
        </Plain>
      </PageContent>
    </PageFrame>
  )
}

export default BookDetailPage