import {ReactElement} from "react";
import styled from "styled-components";
import {SelectableNavigationButton} from "../../../components/buttons/SelectableNavigationButton";
import {useRecoilState} from "recoil";
import {homeInterestState} from "../../../states/Home";
import {InterestCardContent} from "./InterestCardContent";

interface Props {
  buttonNames: string[]
}

export const InterestCardNavigation = ({buttonNames}: Props): ReactElement => {

  const [home, setHome] = useRecoilState(homeInterestState)

  const onClick = (index: number) => () => {
    setHome({
      selected: index
    })
  }

  return (
    <div>
      <HeaderWrapper>
        {buttonNames.map((name: string, index: number) =>
          (<SelectableNavigationButton index={index}
                                       selected={home.selected}
                                       key={index}
                                       onClick={onClick(index)}>{name}</SelectableNavigationButton>))}
      </HeaderWrapper>
      <InterestCardContent/>
    </div>
  )
}

const HeaderWrapper = styled.div`
  height: fit-content;
  display: flex;
  flex-direction: row;
  margin-bottom: 1rem;
`
