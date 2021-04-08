import {ReactElement, ReactNode, useState} from "react";
import styled from "styled-components";
import {Property} from "csstype";

interface Props {
  backgroundColor: string
  children: ReactNode
}

export const FoldableCard = ({backgroundColor, children}: Props): ReactElement => {
  const [folded, setFolded] = useState(true);

  const height: string | undefined = folded ? "6.8rem" : undefined

  const textContentHeight: string | undefined = folded ? "3.8rem" : "fit-content"

  const buttonPositionCalculator: Property.Position | undefined = folded ? "absolute" : undefined

  const buttonText: string = folded ? "더보기" : "접기"

  const onClick = () => {
    setFolded(!folded)
  }

  return (
    <Wrapper style={{backgroundColor, height}}>
      <ChildrenWrapper>
        <TextContentWrapper style={{height: textContentHeight}}>{children}</TextContentWrapper>
      </ChildrenWrapper>
      <ButtonWrapper style={{position: buttonPositionCalculator}} onClick={onClick}>
        <ButtonText>{buttonText}</ButtonText>
      </ButtonWrapper>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  width: auto;
  border-radius: 1.5rem;
  max-width: 36rem;
  position: relative;
  overflow: hidden;
`

const ChildrenWrapper = styled.div`
  padding: 1rem;
`

const TextContentWrapper = styled.div`
  overflow: hidden;
`

const ButtonWrapper = styled.div`
  bottom: 0;
  height: 2rem;
  background-color: rgba(0, 0, 0, 0.1);
  width: 100%;
  border-radius: 0 0 1.5rem 1.5rem;
  display: flex;
  justify-content: center;
  align-items: center;
`

const ButtonText = styled.div`
  font-weight: bold;
  font-size: small;
  color: #3498db;
  height: fit-content;
`

