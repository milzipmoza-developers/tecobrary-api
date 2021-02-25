import React, {useEffect, useState} from "react";
import {Divider, Input, Space, Table} from "antd";
import {LibraryBookSearchData} from "../../interfaces/LibraryBook";
import A from "../../components/A";
import {searchNaverApiBooks} from "../../api/NaverApi";
import {useSetRecoilState} from "recoil";
import {alertState} from "../../states/alertState";
import Search from "antd/es/input/Search";

const columns = [
  {
    title: '제목',
    dataIndex: 'title',
    key: 'title',
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
    title: 'Action',
    key: 'action',
    render: (text: string, record: any) => (
      <Space size="middle">
        <A>등록하기</A>
      </Space>
    ),
  },
];

export default function LibraryBookEnrollPage() {
  const [data, setData] = useState<LibraryBookSearchData>();
  const [currentPage, setCurrentPage] = useState(1);
  const [loading, setLoading] = useState(false);
  const [search, setSearch] = useState({
    keyword: '',
    keptKeyword: ''
  });
  const setAlert = useSetRecoilState(alertState);

  useEffect(() => {
    searchBooks()
  }, [currentPage])

  const setEmptyData = () => {
    setData({
      total: 0,
      start: 0,
      display: 10,
      items: []
    })
  }

  const searchBooks = async () => {
    setLoading(true);
    try {
      const response = await searchNaverApiBooks({
        keyword: search.keptKeyword,
        page: currentPage,
        size: 10
      });
      const data = response.data as LibraryBookSearchData;
      setData(data);
      setAlert({
        type: "info",
        message: `${response.message}`
      });
    } catch (e: any) {
      // todo: 에러 사유, 서버 쪽과 구체화 필요
      setAlert({
        type: "error",
        message: `네이버 api 요청 중 에러가 발생하였습니다.`
      });
      console.log(e);
      setEmptyData();
    }
    setLoading(false);
  }

  function onSearch() {
    if (search.keyword.length < 2) {
      setAlert({
        type: "warning",
        message: `검색어를 두 글자 이상 입력해주세요.`
      });
      return;
    }
    search.keptKeyword = search.keyword
    searchBooks()
  }

  return (
    <div>
      <Search
        placeholder="검색어를 입력해주세요"
        enterButton="검색"
        size="large"
        loading={loading}
        onChange={(e) => {
          search.keyword = e.target.value
        }}
        onSearch={onSearch}
      />
      <Divider/>
      <Table
        dataSource={data ? data.items : []}
        columns={columns}
        rowKey="isbn"
        loading={loading}
        pagination={{
          total: data?.total,
          defaultPageSize: data?.display,
          showSizeChanger: false,
          current: currentPage,
          onChange: ((page: number) => {
            setCurrentPage(page)
          }),
        }}/>
    </div>
  );
}
