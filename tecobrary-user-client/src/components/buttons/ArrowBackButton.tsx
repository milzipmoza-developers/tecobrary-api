import {ReactElement} from "react";
import {ArrowBackIcon} from "../icons/ArrowBackIcon";
import styled from "styled-components";
import {useHistory} from "react-router-dom";

export const ArrowBackButton = (): ReactElement => {
  const history = useHistory();

  const onClick = () => {
    history.goBack()
  }

  return (
    <Wrapper onClick={onClick}>
      <ArrowBackIcon color={"#ffffff"}/>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  background-color: rgba(0, 0, 0, 0.2);
  width: 2rem;
  height: 2rem;
  border-radius: 10%;
  display: flex;
  justify-content: center;
  align-items: center;
  cursor: pointer;
`
