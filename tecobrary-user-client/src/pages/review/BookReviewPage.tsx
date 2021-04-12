import React, {ReactElement, useState} from "react";
import {PageFrame} from "../../components/page/PageFrame";
import {useParams} from "react-router-dom";
import {PageContent} from "../../components/page/PageContent";
import Plain from "../../components/plain/Plain";
import {BookReview} from "../../interfaces";
import {getBookReviews} from "../../api/bookDetail";
import BookReviewInfiniteCard from "./BookReviewInfiniteCard";

interface Params {
  bookId?: string | undefined
}

function BookReviewPage(): ReactElement {

  const {bookId} = useParams<Params>()
  const [reviews, setReviews] = useState<BookReview[]>(getBookReviews.slice(0))
  const [isLast, setLast] = useState(false)

  const onClick = () => {
    getBookReviews.slice(0).forEach((it: BookReview, index: number) => {
      reviews.push(it)
      console.log(index)
    })
  }

  return (
    <PageFrame header={true}>
      <PageContent style={{marginTop: '8rem'}}>
        <Plain title='리뷰를 확인해보세요'
               margin='0 1rem 0 1rem'>
          <BookReviewInfiniteCard isLast={isLast}
                                  buttonOnClick={onClick}
                                  reviews={reviews}/>
        </Plain>
      </PageContent>
    </PageFrame>
  )
}

export default BookReviewPage
