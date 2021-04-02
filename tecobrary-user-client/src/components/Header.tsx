import React, {ReactElement} from "react";
import styled from "styled-components";

const HeaderWrapper = styled.div`
  height: 0px;
  width: 100%;
  position: fixed;
  top: 0px;
  max-width: 36rem;
  background-color: white;
`

function Header(): ReactElement {
  return (
    <>
      <HeaderWrapper></HeaderWrapper>
    </>
  )
}

export default Header;