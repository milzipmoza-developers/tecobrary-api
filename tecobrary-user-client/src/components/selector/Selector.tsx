import {ReactElement, useState} from "react";
import styled from "styled-components";
import {SelectedItem} from "./SelectedItem";
import {SelectorMenu} from "./SelectorMenu";

interface SelectorItem {
  value: string
  displayName: string
}

interface Props {
  placeholder: string
  items: SelectorItem[]
  onChange?: (item: SelectorItem | null) => void
}

function Selector({placeholder, items, onChange}: Props): ReactElement {
  const [selected, setSelected] = useState<SelectorItem | null>(null)
  const [open, setOpen] = useState(false)

  const onClick = () => {
    setOpen(true)
  }

  const onItemClick = (item: SelectorItem) => () => {
    setSelected(item)
    setOpen(false)
    if (onChange) {
      onChange(item)
    }
  }

  return (
    <>
      <Wrapper>
        <SelectedItem placeholder={placeholder}
                      selected={selected?.displayName}
                      onClick={onClick}/>
      </Wrapper>
      {open
        ? <>
          <FullScreen onClick={() => setOpen(false)}/>
          <SelectorMenu items={items} itemOnClick={onItemClick}/>
        </>
        : null}
    </>
  )
}

export default Selector

const Wrapper = styled.div`
  width: auto;
  height: 3rem;
  border-radius: 4px;
  box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
  cursor: pointer;
`

const FullScreen = styled.div`
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.2);
  position: fixed;
  top: 0;
  left: 50%;
  transform: translateX(-50%);
  max-width: 36rem;
  z-index: 100;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`