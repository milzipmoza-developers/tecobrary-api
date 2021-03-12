import React, {useEffect, useState} from "react";
import {Divider, message, Modal} from "antd";
import {
  LibraryBookBasicInfo,
  LibraryBookEnrollData,
  LibraryBookSearchData,
  LibraryBookSearchItem
} from "../../interfaces/LibraryBook";
import {searchNaverApiBooks} from "../../api/NaverApi";
import Search from "antd/es/input/Search";
import {removeHtmlTag} from "../../utils";
import NaverApiBookSearchResultTable from "../../components/libraryBook/enroll/NaverApiBookSearchResultTable";
import EditableBookDetail from "../../components/libraryBook/EditableBookDetail";
import HideableButton from "../../components/common/buttons/HideableButton";
import {enrollLibraryBook} from "../../api/LibraryBooks";

export default function LibraryBookEnrollPage() {
  const [data, setData] = useState<LibraryBookSearchData>({
    total: 0,
    start: 0,
    display: 10,
    items: [],
  });
  const [currentPage, setCurrentPage] = useState(1);
  const [loading, setLoading] = useState(false);
  const [search] = useState({
    keyword: "",
    keptKeyword: "",
  });
  const [isModalVisible, setIsModalVisible] = useState(false);
  const [selectedBook] = useState<LibraryBookSearchItem>({
    title: "",
    author: "",
    publisher: "",
    isbn: "",
    image: "",
    description: "",
  });
  const [isEditable, setEditable] = useState<boolean>(false);
  const [editedBook, setEdited] = useState<LibraryBookBasicInfo>({
    title: "",
    image: "",
    author: "",
    publisher: "",
    description: "",
    isbn: "",
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

  const initEditedBook = () => {
    setEdited({
      title: "",
      image: "",
      author: "",
      publisher: "",
      description: "",
      isbn: "",
    })
  }

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

  const handleEnroll = async () => {
    try {
      const response = await enrollLibraryBook(editedBook);
      const data = response.data as LibraryBookEnrollData;
      setIsModalVisible(false);
      message.info(`"${data.title}" ${response.message}`);
      initEditedBook();
      setEditable(false);
    } catch (e: any) {
      // todo: 에러 사유, 서버 쪽과 구체화 필요
      message.error(`도서 등록 중 에러 발생.`)
      console.log(e);
    }
  };

  const handleCancel = () => {
    setIsModalVisible(false);
    setEditable(false);
  };

  const handleCancelEdit = () => {
    setEditable(false);
    editedBook.title = selectedBook.title;
    editedBook.publisher = selectedBook.publisher;
    editedBook.author = selectedBook.author;
    editedBook.description = selectedBook.description;
    editedBook.image = selectedBook.image;
    editedBook.isbn = selectedBook.isbn;
  }

  const handleEditable = () => {
    setEditable(true);
  }

  const onTableElementClick = (record: any) => {
    selectedBook.title = removeHtmlTag(record.title);
    selectedBook.author = removeHtmlTag(record.author);
    selectedBook.publisher = removeHtmlTag(record.publisher);
    selectedBook.isbn = removeHtmlTag(record.isbn);
    selectedBook.image = record.image;
    selectedBook.description = removeHtmlTag(record.description);
    editedBook.title = selectedBook.title;
    editedBook.publisher = selectedBook.publisher;
    editedBook.author = selectedBook.author;
    editedBook.description = selectedBook.description;
    editedBook.image = selectedBook.image;
    editedBook.isbn = selectedBook.isbn;
    showModal();
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
             onCancel={handleCancel}
             width={1000}
             footer={[
               <HideableButton
                 key="cancel"
                 type="primary"
                 hide={!isEditable}
                 danger
                 onClick={handleCancelEdit}>
                 취소
               </HideableButton>,
               <HideableButton
                 key="back"
                 type="primary"
                 hide={isEditable}
                 onClick={handleEditable}
                 color="green">
                 수정 후 등록하기
               </HideableButton>,
               <HideableButton
                 key="submit"
                 type="primary"
                 hide={false}
                 onClick={handleEnroll}>
                 {isEditable ? "수정된 내용 등록하기" : "등록하기"}
               </HideableButton>,
             ]}>
        <EditableBookDetail isEditable={isEditable} book={selectedBook} editedBook={editedBook}/>
      </Modal>
    </div>
  );
}
