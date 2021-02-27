import React, {useEffect, useState} from "react";
import {Button, Divider, message, Modal} from "antd";
import {LibraryBookSearchData, LibraryBookSearchItem} from "../../interfaces/LibraryBook";
import {searchNaverApiBooks} from "../../api/NaverApi";
import Search from "antd/es/input/Search";
import {removeHtmlTag} from "../../utils";
import NaverApiBookSearchResultTable from "../../components/libraryBook/enroll/NaverApiBookSearchResultTable";
import ModalBookDetail from "../../components/libraryBook/ModalBookDetail";

export default function LibraryBookEnrollPage() {
  const [data, setData] = useState<LibraryBookSearchData>();
  const [currentPage, setCurrentPage] = useState(1);
  const [loading, setLoading] = useState(false);
  const [search] = useState({
    keyword: '',
    keptKeyword: ''
  });
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [selectedBook] = useState<LibraryBookSearchItem>({
    title: '',
    author: '',
    publisher: '',
    isbn: '',
    image: '',
    description: '',
  });

  useEffect(() => {
    whileLoading(() => searchBooks());
  }, [currentPage]);

  const initEmptyData = () => {
    setData({
      total: 0,
      start: 0,
      display: 10,
      items: []
    });
  };

  const searchBooks = async () => {
    if (search.keptKeyword.length < 2) {
      return;
    }
    try {
      const response = await searchNaverApiBooks({
        keyword: search.keptKeyword,
        page: currentPage,
        size: 10
      });
      const data = response.data as LibraryBookSearchData;
      setData(data);
      message.success(`${response.message}`);
    } catch (e: any) {
      // todo: 에러 사유, 서버 쪽과 구체화 필요
      message.error(`네이버 api 요청 중 에러가 발생하였습니다.`)
      console.log(e);
      initEmptyData();
    }
  };

  const onSearch = () => {
    if (search.keyword.length < 2) {
      message.warning(`검색어를 두 글자 이상 입력해주세요.`)
      return;
    }
    search.keptKeyword = search.keyword
    setCurrentPage(1);
    whileLoading(() => searchBooks());
  };

  const whileLoading = (func: () => {}) => {
    setLoading(true);
    func();
    setLoading(false);
  };

  const showModal = () => {
    setIsModalVisible(true);
  };

  const handleOk = () => {
    setIsModalVisible(false);
  };

  const handleCancel = () => {
    setIsModalVisible(false);
  };

  const ModalDefaultFooters = () => {
    return [
      <Button key="back" onClick={handleCancel}>
        수정 후 등록하기
      </Button>,
      <Button key="submit" type="primary" loading={loading} onClick={handleOk}>
        등록하기
      </Button>,
    ]
  }

  const onTableElementClick = (record: any) => {
    showModal();
    selectedBook.title = removeHtmlTag(record.title);
    selectedBook.author = removeHtmlTag(record.author);
    selectedBook.publisher = removeHtmlTag(record.publisher);
    selectedBook.isbn = removeHtmlTag(record.isbn);
    selectedBook.image = record.image;
    selectedBook.description = removeHtmlTag(record.description);
  };

  const onTablePageChange = (page: number) => {
    setCurrentPage(page);
  };

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
      <NaverApiBookSearchResultTable
        loading={loading}
        currentPage={currentPage}
        data={data}
        onTablePageChange={onTablePageChange}
        onTableElementClick={onTableElementClick}
      />
      <Modal title="도서를 등록하시겠습니까?"
             visible={isModalVisible}
             onOk={handleOk}
             onCancel={handleCancel}
             width={1000}
             footer={ModalDefaultFooters}>
        <ModalBookDetail book={selectedBook}/>
      </Modal>
    </div>
  );
}
