import React, {ReactElement, ReactNode} from "react";
import {TransparentHeader} from "../headers/TransparentHeader";
import styled from "styled-components";

interface Props {
  header: boolean
  children: ReactNode
}

export const TransparentPageFrame = ({header, children}: Props): ReactElement => {
  return (
    <Wrapper>
      {header ? <TransparentHeader/> : null}
      {children}
    </Wrapper>
  )
}

const Wrapper = styled.div`
  width: auto;
  height: fit-content;
  min-height: 100vh;
  background-color: #ecf0f1;
  position: relative;
  padding-bottom: 6.3rem;
  display: flex;
  flex-direction: column;
`