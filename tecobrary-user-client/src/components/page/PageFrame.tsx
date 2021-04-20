import React, {ReactElement, ReactNode} from "react";
import {TransparentHeader} from "../headers/TransparentHeader";
import styled from "styled-components";

interface Props {
  top?: string
  header?: boolean
  children: ReactNode
}

export const PageFrame = ({top, header, children}: Props): ReactElement => {
  return (
    <Wrapper>
      {header ? <TransparentHeader/> : null}
      <ChildrenWrapper style={{top}}>
        {children}
      </ChildrenWrapper>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  width: auto;
  height: fit-content;
  min-height: 85vh;
  background-color: #ecf0f1;
  position: relative;
  padding-bottom: 10rem;
  display: flex;
  flex-direction: column;
`

const ChildrenWrapper = styled.div`
  position: relative;
`