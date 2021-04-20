import {ReactElement} from "react";
import styled from "styled-components";

interface Props {
  selected?: string
  placeholder: string
  onClick?: () => void
}

export const SelectedItem = ({selected, placeholder, onClick}: Props): ReactElement => {

  const ConditionalShowElement = () => {
    if (selected) {
      return <Selected>{selected}</Selected>
    }
    return <Placeholder>{placeholder}</Placeholder>
  }

  return (
    <SelectElement onClick={onClick}>
      <ConditionalShowElement/>
    </SelectElement>
  )
}

const SelectElement = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;

  &:hover {
    background-color: #ecf0f1;
  }
`

const Selected = styled.div`
  font-weight: bold;
  font-size: large;
`

const Placeholder = styled.div`
  color: #7f8c8d;
`