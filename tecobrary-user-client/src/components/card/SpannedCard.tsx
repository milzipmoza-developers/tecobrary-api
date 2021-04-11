import {ReactElement, ReactNode} from "react";
import styled from "styled-components";

interface Props {
  title?: string
  children: ReactNode
}

function SpannedCard({title, children}: Props): ReactElement {
  return (
    <Wrapper>
      <Header>
        <Title>{title}</Title>
      </Header>
      {children}
    </Wrapper>
  )
}

export default SpannedCard

const Wrapper = styled.div`
  background-color: white;
  color: black;
  border-radius: 2rem 0 0 2rem;
  width: auto;
  margin-left: 1rem;
  height: fit-content;
  padding: 2rem 0 2rem 2rem;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
`

const Header = styled.div`
  margin-bottom: 1.5rem;
`

const Title = styled.div`
  font-size: large;
  font-weight: bold;
`
