import React, {ReactElement} from "react";
import styled from "styled-components";

const Background = styled.div`
  width: 100vw;
  height: 100vh;
  position: relative;
  display: flex;
  flex-direction: row;
  justify-content: center;
  background-color: #ccc;
`

const Wrapper = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: white;
  max-width: 36rem;
  border: 1px solid black;
`;

function App(): ReactElement {
  return (
    <Background className="background">
      <Wrapper>
        새로운 앱
      </Wrapper>
    </Background>
  );
}

export default App;
