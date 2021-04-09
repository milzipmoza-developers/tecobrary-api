import React, {ReactElement, useState} from "react";
import {useParams} from "react-router-dom";
import {BookDetail} from "../../interfaces";
import {getBookDetail} from "../../api/bookDetail";
import {TransparentPageFrame} from "../../components/page/TransparentPageFrame";
import BookDetailCard from "./BookDetailCard";

interface Params {
  id?: string | undefined
}

function BookDetailPage(): ReactElement {
  const {id} = useParams<Params>()
  // eslint-disable-next-line @typescript-eslint/no-non-null-assertion
  const [bookDetail] = useState<BookDetail>(getBookDetail.get(Number.parseInt(id!)) ? getBookDetail.get(Number.parseInt(id!))! : getBookDetail.get(1)!)

  return (
    <TransparentPageFrame header={true}>
      <div className={"page-content"} style={{height: 'fit-content'}}>
        <BookDetailCard {...bookDetail}/>
      </div>
    </TransparentPageFrame>
  )
}

export default BookDetailPage
