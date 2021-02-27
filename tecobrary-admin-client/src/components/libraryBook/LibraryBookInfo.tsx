import {Divider} from "antd";
import React from "react";
import "./LibraryBookInfo.css";
import BookTitle from "../common/BookTitle";

type Props = {
  title: string,
  author: string,
  publisher: string,
  isbn: string,
  description: string
}

const LibraryBookInfo = ({title, author, publisher, isbn, description}: Props) => {
  return (
    <div className="library-book-info">
      <BookTitle>{title}</BookTitle>
      <Divider/>
      <div className="detail">
        {author} | {publisher} | {isbn}
      </div>
      <div className="description">
        {description}
      </div>
    </div>
  );
};

export default LibraryBookInfo;