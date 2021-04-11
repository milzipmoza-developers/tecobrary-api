import styled from "styled-components";
import {ReactElement} from "react";

interface Props {
  index: number
  selected: number
  children: string
  onClick: () => void
}

export const SelectableNavigationButton = ({index, selected, children, onClick}: Props): ReactElement => {
  if (selected === index) {
    return (
      <HeaderButton onClick={onClick}>
        <SelectedButtonText>{children}</SelectedButtonText>
        <HeaderButtonHighlight/>
      </HeaderButton>
    )
  }
  return (
    <HeaderButton onClick={onClick}>
      <UnselectedButtonText>{children}</UnselectedButtonText>
    </HeaderButton>
  )
}

const HeaderButton = styled.div`
  display: flex;
  flex-direction: column;
  flex: 1;
  height: fit-content;
  margin: 0 1rem 0 1rem;
  text-align: center;
  align-items: center;
  cursor: pointer;
`

const SelectedButtonText = styled.div`
  margin-bottom: 8px;
  font-weight: bold;
`

const UnselectedButtonText = styled.div`
  margin-bottom: 8px;
  font-weight: bold;
  color: #7f8c8d;
`

const HeaderButtonHighlight = styled.div`
  width: 1rem;
  background-color: black;
  height: 3px;
  border-radius: 3px;
`