import {Col, Divider, Input, Row} from "antd";
import TextArea from "antd/es/input/TextArea";
import React from "react";
import {LibraryBookEdit} from "../../interfaces/LibraryBook";

type Props = {
  edited: LibraryBookEdit
  isbn: string
}

const LibraryBookInfoEdit = ({edited, isbn}: Props) => {
  return (
    <div style={{marginRight: "20px"}}>
      <div className="library-book-info">
        <Col className="title">
          <Input addonBefore="제목" defaultValue={edited.title} onChange={(e) => {edited.title = e.target.value}}/>
        </Col>
        <Divider/>
        <Col className="detail">
          <Row>
            <Col span={8}>
              <Input addonBefore="저자" defaultValue={edited.author} onChange={(e) => {edited.author = e.target.value}}/>
            </Col>
            <Col span={8}>
              <Input addonBefore="출판사" defaultValue={edited.publisher} onChange={(e) => {edited.publisher = e.target.value}}/>
            </Col>
            <Col span={8}>
              <Input addonBefore="ISBN" value={isbn} disabled/>
            </Col>
          </Row>
        </Col>
        <Col className="description">
          <TextArea rows={4} defaultValue={edited.description} onChange={(e) => {edited.description = e.target.value}}/>
        </Col>
      </div>
    </div>
  )
}

export default LibraryBookInfoEdit;