import React, {useState} from "react";
import {Button, Col, Divider, Input, Row, Space, Table, Tag} from "antd";
import {LibraryBookElement, LibraryBookSearch} from "../../interfaces/LibraryBook";
import {libraryBookPage} from "../../api/LibraryBooks";
import A from "../../components/A";

const columns = [
  {
    title: '제목',
    dataIndex: 'title',
    key: 'title',
    render: (text: string, value: LibraryBookElement) => <A href={`/library-books/${value.id}`}>{text}</A>,
  },
  {
    title: '저자',
    dataIndex: 'author',
    key: 'author',
  },
  {
    title: '출판사',
    dataIndex: 'publisher',
    key: 'publisher',
  },
  {
    title: 'ISBN',
    dataIndex: 'isbn',
    key: 'isbn',
  },
  {
    title: '카테고리',
    key: 'categories',
    dataIndex: 'categories',
    render: (categories: string[]) => (
      <>
        {categories.map(tag => {
          let color = tag.length > 5 ? 'geekblue' : 'green';
          if (tag === 'loser') {
            color = 'volcano';
          }
          return (
            <Tag color={color} key={tag}>
              {tag.toUpperCase()}
            </Tag>
          );
        })}
      </>
    ),
  },
];

export default function LibraryBookPage() {

  const [search] = useState<LibraryBookSearch>({
    title: "",
    author: "",
    publisher: "",
  });

  const onPageChange = (page: number, pageSize?: number) => {
    console.log(`page changed page=${page} pagesize=${pageSize}`);
  };

  const onSearchButtonClick = () => {
    console.log(`search=${search.title}`)
  }

  const style = {paddingLeft: "10px", paddingRight: "10px"};

  return (
    <>
      <Col>
        <Row>
          <Col span={6} style={style}>
            <Input placeholder="제목" onChange={(e) => {search.title = e.target.value}}/>
          </Col>
          <Col span={6} style={style}>
            <Input placeholder="저자" onChange={(e) => {search.author = e.target.value}}/>
          </Col>
          <Col span={6} style={style}>
            <Input placeholder="출판사" onChange={(e) => {search.publisher = e.target.value}}/>
          </Col>
          <Col span={6} style={style}>
            <Space size="middle">
              <Button type="primary" onClick={onSearchButtonClick}>검색</Button>
              <Button type="primary">등록</Button>
            </Space>
          </Col>
        </Row>
        <Divider/>
        <Table columns={columns} dataSource={libraryBookPage} rowKey="id" pagination={{
          total: libraryBookPage.length,
          pageSize: 10,
          onChange: onPageChange
        }}/>
      </Col>
    </>
  );
}
