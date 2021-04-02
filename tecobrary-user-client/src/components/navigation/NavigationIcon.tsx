import React, {ReactElement} from "react";
import {Home, Person, Reader} from "react-ionicons";
import styled from "styled-components";
import {useRecoilState} from "recoil";
import {navigationState} from "../../states/Navigation";
import {Link, useHistory} from "react-router-dom";

export type iconType = "home" | "reader" | "person"

interface Props {
  index: number
  name: iconType
  height: string
  width: string
  to: string
}

const iconColor = {
  selected: "#34495e",
  unselected: "#7f8c8d"
}

const NavElement = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 4rem;
  height: 4rem;
`

export const NavigationIcon = ({index, name, height, width, to}: Props): ReactElement => {
  const [navigation, setNavigationState] = useRecoilState(navigationState);
  const history = useHistory();

  const color: string = navigation.selected == index ? iconColor.selected : iconColor.unselected

  const onClick = () => {
    if (navigation.selected == index) {
      return
    }
    console.log('navigation selected', index) // todo: remove
    setNavigationState({selected: index})
    history.push(to)
  }

  const CustomIonicon = () => {
    if (name === "home") {
      return <Home width={width} height={height} color={color}/>
    }
    if (name === "reader") {
      return <Reader width={width} height={height} color={color}/>
    }
    if (name === "person") {
      return <Person width={width} height={height} color={color}/>
    }
    return null
  }

  return (
    <NavElement onClick={onClick}>
        <CustomIonicon/>
    </NavElement>
  )
}