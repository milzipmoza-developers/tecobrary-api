import {Col, Image, Row} from "antd";
import React from "react";
import {LibraryBookEdit, LibraryBookSearchItem} from "../../interfaces/LibraryBook";
import LibraryBookInfoEdit from "./LibraryBookInfoEdit";
import LibraryBookInfo from "./LibraryBookInfo";

interface Props {
  isEditable: boolean;
  editedBook: LibraryBookEdit;
  book: LibraryBookSearchItem;
}

const EditableBookDetail = ({isEditable, editedBook, book}: Props) => {
  return (
    <>
      <Row>
        <Col span={6}>
          <Image
            width="100%"
            src={book.image}
            preview={false}
          />
        </Col>
        <Col span={18}>
          {isEditable
            ? <LibraryBookInfoEdit
              edited={editedBook}
              isbn={book.isbn}
            />
            : <LibraryBookInfo
              title={book.title}
              author={book.author}
              publisher={book.publisher}
              isbn={book.isbn}
              description={book.description}
            />}
        </Col>
      </Row>
    </>
  );
};

export default EditableBookDetail;