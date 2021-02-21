import {Space, Table, Tag} from "antd";
import React from "react";
import {Book} from "../interfaces/Book";
import A from "./A";

const columns = [
  {
    title: '일련번호',
    dataIndex: 'bookSerial',
    key: 'bookSerial',
  },
  {
    title: '상태',
    dataIndex: 'bookStatus',
    key: 'bookStatus',
    render: (text: string) => {
      let color = 'green';
      if (text === 'RENT') {
        color = 'volcano';
      }
      return (
        <Tag color={color}>
          {text.toUpperCase()}
        </Tag>
      );
    },
  },
  {
    title: '대여자',
    dataIndex: 'rentMember',
    key: 'rentMember',
  },
  {
    title: '대여일시',
    dataIndex: 'rentDateTime',
    key: 'rentDateTime',
  },
  {
    title: 'Action',
    key: 'action',
    render: (text: string, record: Book) => (
      <Space size="middle">
        <A>반납요청</A>
        <A>삭제</A>
      </Space>
    ),
  },
];

type Props = {
  books?: Book[]
}

const BookTable = ({books}: Props) => {
  return (
    <Table columns={columns} dataSource={books} rowKey="bookSerial" pagination={{
      pageSize: 5
    }}/>
  );
};

export default BookTable;