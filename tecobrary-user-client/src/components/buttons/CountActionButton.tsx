import {ReactElement, ReactNode} from "react";
import styled from "styled-components";

interface Props {
  color?: string
  counts?: number
  children: ReactNode
}

export const CountActionButton = ({color, counts, children}: Props): ReactElement => (
  <Wrapper>
    <ChildrenWrapper>{children}</ChildrenWrapper>
    <CountWrapper style={{color: color ? color : "#34495e"}}>{counts}</CountWrapper>
  </Wrapper>
)

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  width: fit-content;
  height: fit-content;
  align-items: center;
`

const ChildrenWrapper = styled.div`
  margin-right: 0.3rem;
`

const CountWrapper = styled.div`
  font-size: x-small;
  text-align: center;
`