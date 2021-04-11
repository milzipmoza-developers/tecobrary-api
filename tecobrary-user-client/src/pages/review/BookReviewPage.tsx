import React, {ReactElement, useState} from "react";
import {PageFrame} from "../../components/page/PageFrame";
import {useParams} from "react-router-dom";
import {PageContent} from "../../components/page/PageContent";
import Plain from "../../components/plain/Plain";
import BookReviewCard from "../bookDetail/BookReviewCard";
import {BookReview} from "../../interfaces";
import {getBookReviews} from "../../api/bookDetail";

interface Params {
  bookId?: string | undefined
}

function BookReviewPage(): ReactElement {

  const {bookId} = useParams<Params>()
  const [reviews] = useState<BookReview[]>(getBookReviews)

  return (
    <PageFrame header={true}>
      <PageContent style={{marginBottom: '2rem', marginTop: '8rem'}}>
        <Plain title='리뷰를 확인해보세요' margin='0 1rem 0 1rem'>
          <BookReviewCard bookId={bookId}
                          button={false}
                          reviews={reviews}/>
        </Plain>
      </PageContent>
    </PageFrame>
  )
}

export default BookReviewPage
