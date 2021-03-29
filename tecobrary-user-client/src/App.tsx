import React, {ReactElement} from "react";
import styled from "styled-components";
import Header from "./components/Header";
import Navigation from "./components/navigation/Navigation";

const Background = styled.div`
  width: 100vw;
  height: fit-content;
  min-height: 100vh;
  display: flex;
  position: relative;
  flex-direction: row;
  justify-content: center;
  background-color: #ccc;
  overflow: hidden;
`

const Wrapper = styled.div`
  width: 100%;
  height: fit-content;
  position: relative;
  background-color: white;
  max-width: 36rem;
  border: 1px solid black; // todo: remove
  margin-top: 70px; // 
`;

function App(): ReactElement {
  return (
    <Background className="background">
      <Wrapper>
        <Header/>
        새로운 앱
        새로운 앱
        새로운 앱
        새로운 앱
        새로운 앱
        <div style={{height: '1000px', backgroundColor: 'green'}}>새로운 앱</div>
        <div style={{height: '1000px', backgroundColor: 'aqua'}}>새로운 앱</div>
        <Navigation/>
      </Wrapper>
    </Background>
  );
}

export default App;
