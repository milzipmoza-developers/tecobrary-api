import {ReactElement, useState} from "react";
import {ReviewType} from "../../types";
import styled from "styled-components";

interface Props {
  marginBottom?: string
  onChange?: (type: ReviewType) => void
}

const typeToString = (type: ReviewType): string => {
  if (type === 'SHORT_REVIEW') {
    return '직접 쓰기'
  }
  return '블로그 가져오기'
}

export const CustomRadioButton = ({marginBottom, onChange}: Props): ReactElement => {
  const [selected, setSelected] = useState<ReviewType>('SHORT_REVIEW')

  const onClick = (type: ReviewType) => () => {
    setSelected(type)
    if (onChange) {
      onChange(type)
    }
  }

  const leftButtonStyle = () => {
    if (selected === 'SHORT_REVIEW') {
      return {
        backgroundColor: 'black',
        color: 'white'
      }
    }
    return undefined
  }

  const rightButtonStyle = () => {
    if (selected === 'BLOG_IMPORT') {
      return {
        backgroundColor: 'black',
        color: 'white'
      }
    }
    return undefined
  }

  return (
    <Wrapper style={{marginBottom}}>
      <LeftButton onClick={onClick('SHORT_REVIEW')} style={leftButtonStyle()}>
        {typeToString('SHORT_REVIEW')}
      </LeftButton>
      <RightButton onClick={onClick('BLOG_IMPORT')} style={rightButtonStyle()}>
        {typeToString('BLOG_IMPORT')}
      </RightButton>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  width: auto;
  font-size: small;
  border-radius: 1rem;
  box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
  display: flex;
  flex-direction: row;
`

const LeftButton = styled.div`
  flex: 1;
  border-radius: 1rem 0 0 1rem;
  text-align: center;
  padding: 4px;
  cursor: pointer;
`

const RightButton = styled.div`
  flex: 1;
  border-radius: 0 1rem 1rem 0;
  text-align: center;
  padding: 4px;
  cursor: pointer;
`