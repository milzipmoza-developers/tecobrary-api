import React, {ReactElement} from "react";
import styled from "styled-components";

const HeaderWrapper = styled.div`
  height: 70px;
  width: 100%;
  position: fixed;
  top: 0px;
  max-width: 36rem;
  border-bottom: 1px solid black; // todo: remove
  background-color: white;
`

function Header(): ReactElement {
  return (
    <>
      <HeaderWrapper>헤더</HeaderWrapper>
    </>
  )
}

export default Header;