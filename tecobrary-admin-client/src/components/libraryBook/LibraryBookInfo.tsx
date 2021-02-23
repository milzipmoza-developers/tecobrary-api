import {Col, Divider} from "antd";
import React from "react";
import "./LibraryBookInfo.css";

type Props = {
  title?: string,
  author?: string,
  publisher?: string,
  isbn?: string,
  description?: string
}

const LibraryBookInfo = ({title, author, publisher, isbn, description}: Props) => {
  return (
    <div className="library-book-info">
      <Col className="title">
        {title}
      </Col>
      <Divider/>
      <Col className="detail">
        {author} | {publisher} | {isbn}
      </Col>
      <Col className="description">
        {description}
      </Col>
    </div>
  );
};

export default LibraryBookInfo;