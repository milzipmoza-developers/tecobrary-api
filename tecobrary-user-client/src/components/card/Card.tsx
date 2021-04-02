import React, {ReactElement, ReactNode} from "react";
import styled from "styled-components";

interface Props {
  title: string
  children: ReactNode
}

const CardWrapper = styled.div`
  padding: 1.5rem;
  border-radius: 1.5rem;
  width: auto;
  max-width: 36rem;
  background-color: bisque;
`

const CardTitle = styled.div`
  font-size: large;
  font-weight: bold;
  margin-bottom: 1.5rem;
`

function Card({title, children}: Props): ReactElement {
  return (
    <CardWrapper>
      <CardTitle>
        {title}
      </CardTitle>
      {children}
    </CardWrapper>
  )
}

export default Card