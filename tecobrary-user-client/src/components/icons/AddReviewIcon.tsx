import {ReactElement} from "react";
import {Add} from "react-ionicons";
import styled from "styled-components";
import {useHistory} from "react-router-dom";
import {useRecoilState} from "recoil";
import {navigationState} from "../../states/Navigation";

interface Props {
  to: string
}

export const AddReviewIcon = ({to}: Props): ReactElement => {
  const [navigation, setNavigationState] = useRecoilState(navigationState);
  const history = useHistory()

  const onClick = () => {
    history.push(to)
    setNavigationState({selected: 0})
  }

  return (
    <NavElement onClick={onClick}>
      <Add color='white' width='2rem' height='2rem'/>
    </NavElement>
  )
}

const NavElement = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 4rem;
  height: 4rem;
  border-radius: 50%;
  background-color: #2c3e50;
`
