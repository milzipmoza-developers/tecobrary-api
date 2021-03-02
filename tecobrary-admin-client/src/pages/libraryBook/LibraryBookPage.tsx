import React, {useEffect, useState} from "react";
import {Button, Col, Divider, Input, message, Row, Table} from "antd";
import {LibraryBookElement, LibraryBookPageData, LibraryBookSearch} from "../../interfaces/LibraryBook";
import {getPageLibraryBooks} from "../../api/LibraryBooks";
import A from "../../components/A";

const columns = [
  {
    title: '제목',
    dataIndex: 'title',
    key: 'title',
    width: '40%',
    render: (text: string, value: LibraryBookElement) => <A href={`/library-books/${value.id}`}>{text}</A>,
  },
  {
    title: '저자',
    dataIndex: 'author',
    key: 'author',
    width: '15%',
  },
  {
    title: '출판사',
    dataIndex: 'publisher',
    key: 'publisher',
    width: '15%',
  },
  {
    title: 'ISBN',
    dataIndex: 'isbn',
    key: 'isbn',
    width: '20%',
  },
  {
    title: '보유수량',
    dataIndex: 'counts',
    key: 'counts',
    width: '10%',
    render: (text: string) => (`${text} 권`)
  }
];

export default function LibraryBookPage() {

  const [search] = useState<LibraryBookSearch>({
    title: "",
    author: "",
    publisher: "",
  });
  const [libraryBooks, setLibraryBooks] = useState<LibraryBookElement[]>([]);
  const [pagination] = useState({
    page: 1,
    size: 10,
  })

  useEffect(() => {
    pageLibraryBooks()
  }, []);

  const pageLibraryBooks = async() => {
    try {
      const response = await getPageLibraryBooks({
        page: pagination.page,
        size: pagination.size
      });
      const data = response.data as LibraryBookPageData;
      setLibraryBooks(data.books);
      message.success(`${response.message}`);
    } catch (e: any) {
      // todo: 에러 사유, 서버 쪽과 구체화 필요
      message.error(`네이버 api 요청 중 에러가 발생하였습니다.`);
      console.log(e);
    }
  }

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
            <Button type="primary" onClick={onSearchButtonClick}>검색</Button>
          </Col>
        </Row>
        <Divider/>
        <Table columns={columns}
               dataSource={libraryBooks}
               rowKey="id"
               pagination={{
                 pageSize: 10,
                 onChange: onPageChange
               }}/>
      </Col>
    </>
  );
}
