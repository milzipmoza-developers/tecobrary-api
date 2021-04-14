import React, {ReactElement, ReactNode} from "react";
import styled from "styled-components";

interface Props {
  subTitle?: string
  title: string
  margin?: string
  subTitleMargin?: string
  titleMargin?: string
  children: ReactNode
}

function Plain({subTitle, margin, title, subTitleMargin, titleMargin, children}: Props): ReactElement {
  return (
    <Wrapper style={{margin}}>
      {subTitle
        ? <PlainSubTitle style={{margin: subTitleMargin}}>{subTitle}</PlainSubTitle>
        : null}
      <PlainTitle style={{margin: titleMargin ? titleMargin : '0 1rem 1.5rem 1rem'}}>{title}</PlainTitle>
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
`