import React, {ReactElement, ReactNode} from "react";
import styled from "styled-components";

interface Props {
  subTitle?: string
  title: string
  margin?: string
  children: ReactNode
}

function Plain({subTitle, margin, title, children}: Props): ReactElement {
  return (
    <Wrapper style={{margin}}>
      {subTitle
        ? <PlainSubTitle>{subTitle}</PlainSubTitle>
        : null}
      <PlainTitle>{title}</PlainTitle>
      {children}
    </Wrapper>
  )
}

export default Plain

const Wrapper = styled.div`
  width: auto;
  max-width: 36rem;
`

const PlainSubTitle = styled.div`
  font-size: small;
  font-weight: lighter;
  color: #2c3e50;
  margin-bottom: 0.5rem;
`

const PlainTitle = styled.div`
  font-size: large;
  font-weight: bold;
  margin: 0 1rem 1.5rem 1rem;
`