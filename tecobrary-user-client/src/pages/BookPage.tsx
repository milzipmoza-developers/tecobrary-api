import React, {ReactElement, useState} from "react";
import PageFrame from "../components/page/PageFrame";
import {PageContent} from "../components/page/PageContent";
import Card from "../components/card/Card";
import Plain from "../components/plain/Plain";
import {BookDetail} from "../interfaces";
import {getBookDetail} from "../api/bookDetail";
import {useParams} from "react-router-dom";
import {BookCardContent} from "../components/card/BookCardContent";

interface Params {
  id?: string | undefined
}

function BookPage(): ReactElement {
  const {id} = useParams<Params>()
  const [bookDetail] = useState<BookDetail>(getBookDetail)

  console.log('book id', id) // todo: remove

  return (
    <PageFrame title="도서 상세">
      <PageContent>
        <Plain title={bookDetail.title}>
          <BookCardContent {...bookDetail}/>
        </Plain>
      </PageContent>
      <PageContent>
        <Card title="리뷰를 살펴보세요"
              backgroundColor="#E0FEFE">
          리뷰 목록
        </Card>
      </PageContent>
    </PageFrame>
  )
}

export default BookPage
