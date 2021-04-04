import {ReactElement, ReactNode} from "react";
import styled from "styled-components";

interface Props {
  backgroundColor: string
  children: string
}

export const CategoryBadge = ({backgroundColor, children}: Props): ReactElement => {
  return (
    <Wrapper style={{backgroundColor: backgroundColor}}>
      <BadgeText>
        {children}
      </BadgeText>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  height: fit-content;
  width: fit-content;
  padding: 0.1rem 0.2rem 0.1rem 0.2rem;
  margin: 0 0.2rem 0 0.2rem;
  border-radius: 0.3rem;
`

const BadgeText = styled.div`
  width: fit-content;
  height: fit-content;
  font-size: small;
  color: black;
`