import {Button, Col, Row} from "antd";
import React from "react";
import {useSetRecoilState} from "recoil";
import {alertState} from "../states/alertState";

const TestFeature = () => {
  const setAlert = useSetRecoilState(alertState);

  const makeAlert = {
    error: () => setAlert({
      message: "에러발생",
      type: "error"
    }),
    success: () => setAlert({
      message: "성공",
      type: "success"
    }),
    warning: () => setAlert({
      message: "위험",
      type: "warning"
    }),
    info: () => setAlert({
      message: "정보",
      type: "info"
    }),
  }

  return (
    <Col>
      <Row>
        <div>얼럿</div>
        <Button onClick={makeAlert.error}>에러</Button>
        <Button onClick={makeAlert.success}>성공</Button>
        <Button onClick={makeAlert.warning}>워닝</Button>
        <Button onClick={makeAlert.info}>기본</Button>
      </Row>
    </Col>
  );
};

export default TestFeature;