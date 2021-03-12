import React, {useEffect, useState} from "react";
import {useHistory, useParams} from "react-router-dom";
import {useSetRecoilState} from "recoil";
import {alertState} from "../../states/alertState";
import {LibraryBookDetailData, LibraryBookEdit, LibraryBookUpdateData} from "../../interfaces/LibraryBook";
import {requestLibraryBookDetail, requestUpdateLibraryBook} from "../../api/LibraryBooks";
import {Button, Col, Divider, Image, Input, message, Row, Skeleton, Space} from "antd";
import LibraryBookInfo from "../../components/libraryBook/LibraryBookInfo";
import BookTable from "../../components/BookTable";
import LibraryBookInfoEdit from "../../components/libraryBook/LibraryBookInfoEdit";
import HideableButton from "../../components/common/buttons/HideableButton";
import Hideable from "../../components/common/Hideable";
import ColorButton from "../../components/common/buttons/ColorButton";
import {Book, SerialNumber} from "../../interfaces/Book";
import {requestEnrollBook} from "../../api/Books";

type urlParams = {
  id: string;
}

export default function LibraryBookDetailPage() {
  const {id}: urlParams = useParams();
  const setAlert = useSetRecoilState(alertState);
  const history = useHistory();
  const [detail, setDetail] = useState<LibraryBookDetailData>({
    id: 0,
    title: "",
    image: "",
    author: "",
    publisher: "",
    isbn: "",
    description: "",
    books: []
  });
  const [isEditable, setEditable] = useState<boolean>(false);
  const [edited, setEdited] = useState<LibraryBookEdit>({
    title: "",
    image: "",
    author: "",
    publisher: "",
    description: ""
  });
  const [book, setBook] = useState<SerialNumber>({
    serialNumber: ""
  });

  useEffect(() => {
    let number = parseInt(id);
    if (!number) {
      setAlert({
        type: "warning",
        message: "잘못된 접근입니다."
      });
      history.push("/");
    }
  });

  useEffect(() => {
    getDetail();
  }, [])

  useEffect(() => {
    setEdited({
      title: detail.title,
      image: detail.image,
      author: detail.author,
      publisher: detail.publisher,
      description: detail.description
    });
  }, [detail]);

  const getDetail = async () => {
    try {
      const response = await requestLibraryBookDetail(id);
      const detail = response.data as LibraryBookDetailData;
      setDetail(detail);
      message.info(response.message);
    } catch (e: any) {
      message.error(`api 요청 중 에러가 발생하였습니다.`);
      history.push("/library-books");
    }
  }

  const onEditButtonClick = () => {
    setEditable(true);
  };

  const onCancelButtonClick = () => {
    setEditable(false);
    edited.title = detail?.title;
    edited.image = detail?.image;
    edited.author = detail?.author;
    edited.publisher = detail?.publisher;
    edited.description = detail?.description;
  };

  const onCompleteButtonClick = async () => {
    setEditable(false);
    try {
      const response = await requestUpdateLibraryBook(id, edited);
      const data = response.data as LibraryBookUpdateData;
      setDetail({
        books: detail.books,
        ...data
      });
      message.info(response.message);
    } catch (e: any) {
      // todo: 서버 쪽과 메시지 구체화
      console.error(e);
      message.error(`도서 정보 업데이트에 실패하였습니다.`);
    }
  }

  const onBookAddButtonClick = async () => {
    if (book.serialNumber === "") {
      message.warn("등록할 장서 번호를 입력해주세요.");
      setBook({serialNumber: ""})
      return;
    }
    if (!/[0-9]+/.test(book.serialNumber)) {
      message.warn("숫자로 입력해주세요.");
      setBook({serialNumber: ""})
      return;
    }
    try {
      const response = await requestEnrollBook(id, book);
      const books = response.data.books as Book[];
      setDetail({
        ...detail,
        books: books,
      });
      setBook({serialNumber: ""})
    } catch (e: any) {
      console.error(e);
      message.error(`장서 등록에 실패하였습니다.`);
    }
  }

  if (!detail) {
    message.error(`도서 정보를 불러올 수 없습니다.`);
    history.push("/library-books");
  }

  return (
    <>
      <Row>
        <Col span={20}>
          {isEditable
            ? <LibraryBookInfoEdit
              edited={edited}
              isbn={detail.isbn}
            />
            : <LibraryBookInfo
              title={detail.title}
              author={detail.author}
              publisher={detail.publisher}
              isbn={detail.isbn}
              description={detail.description}
            />}
        </Col>
        <Col span={4}>
          <Image
            width="100%"
            src={detail.image}
          />
        </Col>
        <Divider/>
        <Col span={24}>
          <Row justify="end">
            <Space align="end">
              <Hideable hide={!isEditable}>
                <Input addonBefore="추가할 장서 번호"
                       placeholder="숫자로 입력해주세요."
                       value={book.serialNumber}
                       onChange={(e) => {setBook({serialNumber: e.target.value})}}/>
              </Hideable>
              <Hideable hide={!isEditable}>
                <ColorButton type="primary" color="orange" onClick={onBookAddButtonClick}>도서 추가</ColorButton>
              </Hideable>
              <HideableButton type="primary" hide={!isEditable} onClick={onCompleteButtonClick}>완료</HideableButton>
              <HideableButton type="primary" danger hide={!isEditable} onClick={onCancelButtonClick}>취소</HideableButton>
              <Button type="primary" danger disabled={isEditable} onClick={onEditButtonClick}>수정</Button>
            </Space>
          </Row>
        </Col>
      </Row>
      <Divider/>
      <BookTable books={detail.books}/>
    </>
  )
}