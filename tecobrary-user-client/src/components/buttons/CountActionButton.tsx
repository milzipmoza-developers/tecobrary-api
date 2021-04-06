import {ReactNode} from "react";
import styled from "styled-components";

interface Props {
  counts?: number
  children: ReactNode
}

export const CountActionButton = ({counts, children}: Props) => (
  <Wrapper>
    <ChildrenWrapper>{children}</ChildrenWrapper>
    <CountWrapper>{counts}</CountWrapper>
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
  color: #34495e;
  text-align: center;
`