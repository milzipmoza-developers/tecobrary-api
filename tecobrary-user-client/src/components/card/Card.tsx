import React, {ReactElement, ReactNode} from "react";
import styled from "styled-components";
import CardButton from "./CardButton";

interface Props {
  title?: string | ReactElement
  children: ReactNode
  backgroundColor: string
  buttonText?: string
  buttonTo?: string
}

const CardWrapper = styled.div`
  border-radius: 1.5rem;
  width: auto;
  max-width: 36rem;
`

const CardInside = styled.div`
  padding: 1.5rem;
  width: auto;
`

const CardTitle = styled.div`
  font-size: large;
  font-weight: bold;
  margin-bottom: 1.5rem;
`

function Card({title, backgroundColor, children, buttonText, buttonTo}: Props): ReactElement {
  return (
    <CardWrapper style={{backgroundColor: `${backgroundColor}`}}>
      <CardInside>
        {title ? <CardTitle>
          {title}
        </CardTitle> : null}
        {children}
      </CardInside>
      { buttonText && buttonTo
        ? <CardButton text={buttonText} to={buttonTo}/>
        : null}
    </CardWrapper>
  )
}

export default Card