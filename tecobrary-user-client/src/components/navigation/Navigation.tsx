import React, {ReactElement} from "react";
import styled from "styled-components";
import {NavigationIcon} from "./NavigationIcon";

const NavigationWrapper = styled.div`
  height: 4rem;
  width: 100%;
  position: fixed;
  bottom: 0px;
  max-width: 36rem;
  border-top: 1px solid #7f8c8d;
  background-color: rgba(236, 240, 241, 0.95);
`

const NavigationContent = styled.div`
  display: flex;
  flex-direction: row;
  width: 100%;
  min-width: fit-content;
  height: 100%;
  justify-content: space-around;
  align-items: center;
`

function Navigation(): ReactElement {
  return (
    <NavigationWrapper>
      <NavigationContent>
        <NavigationIcon index={1} name="home" width={"2rem"} height={"2rem"} to="/"/>
        <NavigationIcon index={2} name="reader" width={"2rem"} height={"2rem"} to="/timeline"/>
        <NavigationIcon index={3} name="person" width={"2rem"} height={"2rem"} to="/my-page"/>
      </NavigationContent>
    </NavigationWrapper>
  );
}

export default Navigation;