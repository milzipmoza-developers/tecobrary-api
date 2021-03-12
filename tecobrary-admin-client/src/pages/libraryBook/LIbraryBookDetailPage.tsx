import React, {useEffect, useState} from "react";
import {useHistory, useParams} from "react-router-dom";
import {useSetRecoilState} from "recoil";
import {alertState} from "../../states/alertState";
import {LibraryBookDetailData, LibraryBookEdit} from "../../interfaces/LibraryBook";
import {requestLibraryBookDetail} from "../../api/LibraryBooks";
import {Button, Col, Divider, Image, message, Row, Space} from "antd";
import LibraryBookInfo from "../../components/libraryBook/LibraryBookInfo";
import BookTable from "../../components/BookTable";
import LibraryBookInfoEdit from "../../components/libraryBook/LibraryBookInfoEdit";
import HideableButton from "../../components/common/buttons/HideableButton";

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
      title: detail?.title,
      image: detail?.image,
      author: detail?.author,
      publisher: detail?.publisher,
      description: detail?.description
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

  const onCompleteButtonClick = () => {
    setEditable(false);
    // 요청
    console.log('업데이트 요청');
    console.log(edited);

    setAlert({
      type: "info",
      message: "도서 정보가 수정되었습니다."
    });
  }

  if (!detail) {
    setAlert({
      type: "error",
      message: "도서 정보를 불러올 수 없습니다."
    });
    return null;
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