import React, {ReactElement, ReactNode} from "react";
import styled from "styled-components";

interface Props {
  title?: string
  backgroundColor?: string
  children: ReactNode
}

const PageWrapper = styled.div`
  width: auto;
  padding: 2rem 1rem 1rem 1rem;
  max-width: 36rem;
  margin-bottom: 4rem; // for nav
`

const PageTitle = styled.div`
  margin-left: 0.5rem;
  margin-top: 1rem;
  font-weight: bold;
  font-size: xx-large;
`

function PageFrame({title, backgroundColor, children}: Props): ReactElement {
  return (
    <PageWrapper style={{backgroundColor}}>
      {title ? <PageTitle>
        {title}
      </PageTitle> : null}
      {children}
    </PageWrapper>
  )
}

export default PageFrame;