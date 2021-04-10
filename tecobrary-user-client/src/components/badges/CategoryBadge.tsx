import {ReactElement, ReactNode} from "react";
import styled from "styled-components";
import {Property} from "csstype";

interface Props {
  fontWeight?: Property.FontWeight
  backgroundColor: string
  children: string
}

export const CategoryBadge = ({fontWeight, backgroundColor, children}: Props): ReactElement => {
  return (
    <Wrapper style={{backgroundColor: backgroundColor}}>
      <BadgeText style={{fontWeight}}>
        {children}
      </BadgeText>
    </Wrapper>
  )
}

const Wrapper = styled.span`
  height: fit-content;
  width: fit-content;
  padding: 0.1rem 0.2rem 0.1rem 0.2rem;
  margin: 0 0.2rem 0 0.2rem;
  border-radius: 0.3rem;
`

const BadgeText = styled.a`
  width: fit-content;
  height: fit-content;
  font-size: small;
  color: black;
`