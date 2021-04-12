import React, {ReactElement, ReactNode} from "react";
import styled from "styled-components";
import CardButton from "./CardButton";

interface Props {
  title?: string | ReactElement
  children: ReactNode
  backgroundColor: string
  buttonOnClick?: () => void
  buttonText?: string
  boxShadow?: string
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

function ExpandableCard({title, backgroundColor, buttonText, buttonOnClick, children, boxShadow}: Props): ReactElement {
  return (
    <CardWrapper style={{backgroundColor, boxShadow}}>
      <CardInside>
        {title ? <CardTitle>
          {title}
        </CardTitle> : null}
        {children}
      </CardInside>
      { buttonText && buttonOnClick
        ? <CardButton text={buttonText} onClick={buttonOnClick}/>
        : null}
    </CardWrapper>
  )
}

export default ExpandableCard