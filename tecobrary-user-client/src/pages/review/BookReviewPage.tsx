import React, {ReactElement} from "react";
import {PageFrame} from "../../components/page/PageFrame";
import {useParams} from "react-router-dom";

interface Params {
  bookId?: string | undefined
}

function BookReviewPage(): ReactElement {

  const {bookId} = useParams<Params>()

  return (
    <PageFrame header={true}>
      더많은 리뷰 보기
      {bookId}
    </PageFrame>
  )
}

export default BookReviewPage
