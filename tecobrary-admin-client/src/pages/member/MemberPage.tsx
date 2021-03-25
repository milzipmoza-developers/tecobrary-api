import React, {useState} from "react";
import {Button, Col, Divider, Input, Row, Space, Table, Tag} from "antd";
import A from "../../components/A";

interface MemberInfo {
  id: number;
  number: string;
  nickName: string;
  authority: string;
}

const columns = [
  {
    title: '#',
    dataIndex: 'id',
    key: 'id',
    width: '10%',
  },
  {
    title: '회원번호',
    dataIndex: 'number',
    key: 'number',
    width: '20%',
  },
  {
    title: '닉네임',
    dataIndex: 'nickName',
    key: 'nickName',
    width: '30%',
  },
  {
    title: '권한',
    dataIndex: 'authority',
    key: 'authority',
    width: '20%',
    render: (text: string) => {
      let color = 'green';
      if (text === 'BANNED') {
        color = 'red'
      }
      if (text === 'UNAUTHORIZED') {
        color = 'yellow'
      }
      if (text === 'AUTHORIZED') {
        color = '#2f54eb';
      }
      if (text === 'MANAGER') {
        color = '#722ed1'
      }
      if (text === 'KING') {
        color = 'black';
      }
      return (
        <Tag color={color}>
          {text.toUpperCase()}
        </Tag>
      );
    },
  },
  {
    title: 'Action',
    key: 'action',
    width: '20%',
    render: (text: string, record: MemberInfo) => (
      <Space size="middle">
        <A disabled>반납요청</A>
        <A disabled>삭제</A>
      </Space>
    ),
  },
];

const members: MemberInfo[] = [
  {
    id: 1,
    number: "19930705",
    nickName: "루피",
    authority: "KING"
  },
  {
    id: 2,
    number: "20200103",
    nickName: "카마도 탄지로",
    authority: "MANAGER"
  },
  {
    id: 3,
    number: "20210302",
    nickName: "교주로 렌고쿠",
    authority: "BANNED"
  },
  {
    id: 4,
    number: "20000705",
    nickName: "젠이츠",
    authority: "UNAUTHORIZED"
  },
  {
    id: 5,
    number: "19970705",
    nickName: "상디",
    authority: "AUTHORIZED"
  },
]

export default function MemberPage() {

  const [search, setSearch] = useState({
    name: "",
    role: ""
  })

  const style = {paddingLeft: "10px", paddingRight: "10px"};

  return (
    <>
      <Col>
        <Row>
          <Col span={6} style={style}>
            <Input placeholder="닉네임" onChange={(e) => {search.name = e.target.value}}/>
          </Col>
          <Col span={6} style={style}>
            <Input placeholder="등급" onChange={(e) => {search.role = e.target.value}}/>
          </Col>
          <Col span={6} style={style}>
            <Button type="primary" onClick={() => console.log("search")}>검색</Button>
          </Col>
        </Row>
        <Divider/>
        <Table columns={columns}
               dataSource={members}
               rowKey="id"
               pagination={{
                 pageSize: 10
               }}/>
      </Col>
    </>
  );
}