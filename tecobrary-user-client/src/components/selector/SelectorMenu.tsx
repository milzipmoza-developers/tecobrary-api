import {ReactElement} from "react";
import {SelectorElement} from "./SelectorElement";
import styled from "styled-components";

interface SelectorItem {
  value: string
  displayName: string
}

interface Props {
  items: SelectorItem[]
  itemOnClick: (item: SelectorItem) => () => void
}

export const SelectorMenu = ({items, itemOnClick}: Props): ReactElement => {
  return (
    <Wrapper>
      <Menu>
        {items.map((it: SelectorItem, index: number) => (
          <SelectorElement key={index} itemName={it.displayName} onClick={itemOnClick(it)}/>
        ))}
      </Menu>
    </Wrapper>
  )
}

const Wrapper = styled.div`
  width: 100%;
  left: 50%;
  bottom: 0;
  position: fixed;
  transform: translateX(-50%);
  max-width: 36rem;
  z-index: 102;
  height: fit-content;
  display: flex;
`

const Menu = styled.div`
  background-color: white;
  border-radius: 2rem 2rem 0 0;
  box-shadow: rgba(0, 0, 0, 0.15) 0px 2px 8px;
  padding: 2rem 2rem 4rem 2rem;
  width: 100%;
`
