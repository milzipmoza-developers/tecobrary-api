import React, {ReactElement, ReactNode} from "react";
import styled from "styled-components";

interface Props {
  subTitle?: string
  title: string
  children: ReactNode
}

const PlainWrapper = styled.div`
  padding: 0.5rem;
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
  margin-bottom: 1.5rem;
`

function Plain({subTitle, title, children}: Props): ReactElement {
  return (
    <PlainWrapper>
      {subTitle
        ? <PlainSubTitle>{subTitle}</PlainSubTitle>
        : null}
      <PlainTitle>{title}</PlainTitle>
      {children}
    </PlainWrapper>
  )
}

export default Plain