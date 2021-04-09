import {ArrowBackButton} from "../buttons/ArrowBackButton";
import React, {ReactElement} from "react";
import styled from "styled-components";

export const TransparentHeader = (): ReactElement => {
  return (
    <HeaderWrapper>
      <ArrowBackButton/>
    </HeaderWrapper>
  )
}

const HeaderWrapper = styled.div`
  width: 100%;
  height: 4rem;
  position: fixed;
  max-width: 36rem;
  margin: 2rem 1rem 0 1rem;
`