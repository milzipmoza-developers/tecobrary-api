import React, {useEffect, useState} from "react";
import {useHistory, useParams} from "react-router-dom";
import {useSetRecoilState} from "recoil";
import {alertState} from "../states/alertState";
import {LibraryBookDetail, LibraryBookEdit} from "../interfaces/LibraryBook";
import {libraryBookDetail} from "../api/LibraryBooks";
import {Button, Col, Divider, Image, Row, Space} from "antd";
import LibraryBookInfo from "../components/LibraryBookInfo";
import BookTable from "../components/BookTable";
import LibraryBookInfoEdit from "../components/libraryBook/LibraryBookInfoEdit";

type urlParams = {
  id: string;
}

export default function LibraryBookDetailPage() {
  const {id}: urlParams = useParams();
  const setAlert = useSetRecoilState(alertState);
  const history = useHistory();
  const [detail, setDetail] = useState<LibraryBookDetail>();
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
    setDetail(libraryBookDetail);
    setEdited({
      title: detail?.title,
      image: detail?.image,
      author: detail?.author,
      publisher: detail?.publisher,
      description: detail?.description
    });
  }, [detail]);

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

  return (
    <>
      <Row>
        <Col span={20}>
          {isEditable
            ? <LibraryBookInfoEdit
              edited={edited}
              isbn={detail?.isbn}
            />
            : <LibraryBookInfo
              title={detail?.title}
              author={detail?.author}
              publisher={detail?.publisher}
              isbn={detail?.isbn}
              description={detail?.description}
            />}
        </Col>
        <Col span={4}>
          <Image
            width="100%"
            src={detail?.image}
          />
        </Col>
        <Divider/>
        <Col span={24}>
          <Row justify="end">
            <Space align="end">
              {isEditable ? <Button type="primary" onClick={onCompleteButtonClick}>완료</Button> : null}
              {isEditable ? <Button danger type="primary" onClick={onCancelButtonClick}>취소</Button> : null}
              <Button type="primary" danger disabled={isEditable} onClick={onEditButtonClick}>수정</Button>
            </Space>
          </Row>
        </Col>
      </Row>
      <Divider/>
      <BookTable books={detail?.books}/>
    </>
  )
}