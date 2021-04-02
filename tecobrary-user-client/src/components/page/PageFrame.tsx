import React, {ReactElement, ReactNode} from "react";
import styled from "styled-components";

interface Props {
  title: string
  children: ReactNode
}

const PageWrapper = styled.div`
  width: auto;
  padding: 1rem;
  max-width: 36rem;
`

const PageTitle = styled.div`
  margin-left: 0.5rem;
  margin-top: 1rem;
  font-weight: bold;
  font-size: x-large;
`

function PageFrame({title, children}: Props): ReactElement {
  return (
    <PageWrapper>
      <PageTitle>
        {title}
      </PageTitle>
      {children}
    </PageWrapper>
  )
}

export default PageFrame;