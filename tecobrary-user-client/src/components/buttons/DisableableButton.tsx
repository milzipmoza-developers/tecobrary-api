import {ReactElement} from "react";
import styled from "styled-components";

interface Props {
  disabled: boolean
  name: string
  onClick: () => void
}

export const DisableableButton = ({disabled, name, onClick}: Props): ReactElement | null => {

  if (disabled) {
    return null
  }

  return (
    <Wrapper onClick={onClick}>
      <Text>{name}</Text>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  width: auto;
  height: 3rem;
  border-radius: 1rem;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: black;
  cursor: pointer;
`

const Text = styled.div`
  font-weight: bold;
  color: white;
`