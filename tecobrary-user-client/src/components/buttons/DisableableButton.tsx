import {ReactElement} from "react";
import styled from "styled-components";

interface Props {
  disabled: boolean
  name: string
  onClick: () => void
}

export const DisableableButton = ({disabled, name, onClick}: Props): ReactElement | null => {

  if (disabled) {
    return( //#7f8c8d
      <DisabledWrapper>
        <Text>{name}</Text>
      </DisabledWrapper>
    )
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
const DisabledWrapper = styled.div`
  width: auto;
  height: 3rem;
  border-radius: 1rem;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #bdc3c7;
  cursor: pointer;
`

const Text = styled.div`
  font-weight: bold;
  color: white;
`