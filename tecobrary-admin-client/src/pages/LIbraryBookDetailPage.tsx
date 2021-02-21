import React, {useEffect, useState} from "react";
import {
  useParams,
  useHistory
} from "react-router-dom";
import {useSetRecoilState} from "recoil";
import {alertState} from "../states/alertState";
import {LibraryBookDetail} from "../interfaces/LibraryBook";
import {libraryBookDetail} from "../api/LibraryBooks";
import {Col, Row, Image, Divider} from "antd";
import LibraryBookInfo from "../components/LibraryBookInfo";
import BookTable from "../components/BookTable";

type urlParams = {
  id: string;
}

export default function LibraryBookDetailPage() {
  const { id }: urlParams = useParams();
  const setAlert = useSetRecoilState(alertState);
  const history = useHistory();
  const [detail, setDetail] = useState<LibraryBookDetail>();

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
    setDetail(libraryBookDetail)
  }, [detail])

  return (
    <>
      <Row>
        <Col span={20}>
          <LibraryBookInfo
            title={detail?.title}
            author={detail?.author}
            publisher={detail?.publisher}
            isbn={detail?.isbn}
            description={detail?.description}
          />
        </Col>
        <Col span={4}>
          <Image
            width="100%"
            src={detail?.image}
          />
        </Col>
      </Row>
      <Divider/>
      <BookTable books={detail?.books}/>
    </>
  )
}