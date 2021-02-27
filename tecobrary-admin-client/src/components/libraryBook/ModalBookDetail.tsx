import {Col, Image, Row} from "antd";
import React from "react";
import {LibraryBookSearchItem} from "../../interfaces/LibraryBook";

interface Props {
  book: LibraryBookSearchItem;
}

const ModalBookDetail = ({book}: Props) => {
  return (
    <Col>
      <Row>
        <Col flex={2} style={{marginRight: "1vw"}}>
          <Image
            width="100%"
            src={book.image}
            preview={false}
          />
        </Col>
        <Col flex={3}>
          <p>{book.title}</p>
          <p>{book.author}</p>
          <p>{book.publisher}</p>
          <p>{book.isbn}</p>
          <p>{book.description}</p>
        </Col>
      </Row>
    </Col>
  )
}

export default ModalBookDetail;