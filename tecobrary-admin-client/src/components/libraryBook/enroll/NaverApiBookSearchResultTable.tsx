import {Table} from "antd";
import React from "react";
import {LibraryBookSearchData} from "../../../interfaces/LibraryBook";

const _TITLE_MAX_LENGTH = 50
const _TITLE_SHOW_LENGTH = 40
const _AUTHOR_MAX_LENGTH = 20
const _PUBLISHER_MAX_LENGTH = 10
const _ISBN_MAX_LENGTH = 25

const columns = [
  {
    title: '제목',
    dataIndex: 'title',
    key: 'title',
    width: '40%',
    render: (text: string) => {
      const showText = text.length > _TITLE_MAX_LENGTH
        ? text.substr(0, _TITLE_SHOW_LENGTH) + "..."
        : text;
      return <div dangerouslySetInnerHTML={{__html: showText}}/>
    }
  },
  {
    title: '저자',
    dataIndex: 'author',
    key: 'author',
    render: (text: string) => {
      const showText = text.length > _AUTHOR_MAX_LENGTH
        ? text.substr(0, _AUTHOR_MAX_LENGTH) + "..."
        : text;
      return <div dangerouslySetInnerHTML={{__html: showText}}/>
    }
  },
  {
    title: '출판사',
    dataIndex: 'publisher',
    key: 'publisher',
    render: (text: string) => {
      const showText = text.length > _PUBLISHER_MAX_LENGTH
        ? text.substr(0, _PUBLISHER_MAX_LENGTH) + "..."
        : text;
      return <div dangerouslySetInnerHTML={{__html: showText}}/>
    }
  },
  {
    title: 'ISBN',
    dataIndex: 'isbn',
    key: 'isbn',
    width: '20%',
    render: (text: string) => {
      const showText = text.length > _ISBN_MAX_LENGTH
        ? text.substr(0, _ISBN_MAX_LENGTH) + "..."
        : text;
      return <div dangerouslySetInnerHTML={{__html: showText}}/>
    }
  },
];

interface Props {
  data?: LibraryBookSearchData;
  loading: boolean;
  currentPage: number;
  onTablePageChange: (page: number) => void
  onTableElementClick: (record: any) => void
}

const NaverApiBookSearchResultTable = (props: Props) => {
  return (
    <Table
      dataSource={props.data ? props.data.items : []}
      columns={columns}
      rowKey="isbn"
      loading={props.loading}
      pagination={{
        total: props.data?.total,
        defaultPageSize: props.data?.display,
        showSizeChanger: false,
        current: props.currentPage,
        onChange: props.onTablePageChange,
      }}
      onRow={(record, rowIndex) => {
        return {
          onClick: props.onTableElementClick,
        };
      }}
    />
  )
}

export default NaverApiBookSearchResultTable;