import {Alert} from "antd";
import React from "react";
import {useRecoilValue, useSetRecoilState} from "recoil";
import {alertSelector, alertState} from "../states/alertState";

const GlobalAlert = () => {

  const alert = useRecoilValue(alertState);
  const showAlert = useRecoilValue(alertSelector);
  const setAlert = useSetRecoilState(alertState);

  const closeAlert = () => {
    setAlert({
      message: "",
      type: undefined
    })
  }

  return (
    <>
      {showAlert
        ? <Alert type={alert.type} message={alert.message} banner closable afterClose={closeAlert}/>
        : null}
    </>
  )
}

export default GlobalAlert;