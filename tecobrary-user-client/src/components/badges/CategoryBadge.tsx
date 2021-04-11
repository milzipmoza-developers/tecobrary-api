import {ReactElement} from "react";
import styled from "styled-components";
import {Property} from "csstype";

interface Props {
  size?: 'small' | 'medium'
  fontWeight?: Property.FontWeight
  backgroundColor: string
  children: string
}

const selectableSize = {
  small: {
    fontSize: 'x-small',
  },
  medium: {
    fontSize: 'small'
  }
}

function getSize(size: string): any {
  if (size === 'small') {
    return selectableSize.small
  }
  if (size === 'medium') {
    return selectableSize.medium
  }
  return null
}

export const CategoryBadge = ({size, fontWeight, backgroundColor, children}: Props): ReactElement => {

  const badgeSize: string = size ? size : 'medium'

  return (
    <Wrapper style={{backgroundColor: backgroundColor}}>
      <BadgeText style={{fontWeight, ...getSize(badgeSize)}}>
        {children}
      </BadgeText>
    </Wrapper>
  )
}

const Wrapper = styled.span`
  height: fit-content;
  width: fit-content;
  padding: 2px 4px 2px 4px;
  margin: 0 4px 0 4px;
  border-radius: 0.3rem;
  display: flex;
  justify-content: center;
  align-items: center;
`

const BadgeText = styled.a`
  width: fit-content;
  height: fit-content;
  font-size: small;
  color: black;
`
