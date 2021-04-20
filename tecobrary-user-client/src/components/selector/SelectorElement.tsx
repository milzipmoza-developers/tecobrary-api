import {ReactElement} from "react";
import styled from "styled-components";

interface Props {
  itemName: string
  onClick: () => void
}

export const SelectorElement = ({itemName, onClick}: Props): ReactElement => {
  return (
    <Wrapper onClick={onClick}>
      <Text>{itemName}</Text>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 3rem;

  &:hover {
    background-color: #ecf0f1;
    font-weight: bold;
  }
`

const Text = styled.div`
  font-size: large;
`