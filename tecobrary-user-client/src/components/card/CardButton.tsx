import React, {ReactElement} from "react";
import styled from "styled-components";
import {useHistory} from "react-router-dom";

export interface Props {
  text: string
  to?: string
  onClick?: () => void
}


const CardButtonWrapper = styled.div`
  border-radius: 0 0 1.5rem 1.5rem;
  width: auto;
  height: 3rem;
  background-color: rgba(0, 0, 0, 0.1);
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  cursor: pointer;
`

const CardText = styled.div`
  font-weight: bold;
  font-size: small;
  color: #3498db;
  height: fit-content;
`

function CardButton({text, to, onClick}: Props): ReactElement {

  const history = useHistory()

  const onClickTo = () => {
    history.push(`${to}`)
  }

  return (
    <CardButtonWrapper onClick={onClick ? onClick : onClickTo}>
      <CardText>
        {text}
      </CardText>
    </CardButtonWrapper>
  )
}

export default CardButton