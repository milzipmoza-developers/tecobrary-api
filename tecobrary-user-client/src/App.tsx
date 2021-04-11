import React, {ReactElement} from "react";
import styled from "styled-components";
import Navigation from "./components/navigation/Navigation";
import {Route, Switch} from "react-router-dom";
import TimelinePage from "./pages/TimelinePage";
import MyPage from "./pages/MyPage";
import NotFoundPage from "./pages/NotFoundPage";
import BookDetailPage from "./pages/bookDetail/BookDetailPage";
import ScrollToTop from "./routes/ScrollToTop";
import HomePage from "./pages/home/HomePage";
import CategoriesPage from "./pages/CategoriesPage";
import CategoryBookPage from "./pages/CategoryBookPage";

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
  height: 100%;
  position: relative;
  background-color: white;
  max-width: 36rem;
`;

function App(): ReactElement {
  return (
    <Background className="background">
      <Wrapper>
        {/*<Header/>*/}
        <ScrollToTop/>
        <Switch>
          <Route exact path={"/"} component={HomePage}/>
          <Route exact path={"/timeline"} component={TimelinePage}/>
          <Route exact path={"/my-page"} component={MyPage}/>
          <Route exact path={"/books/:id"} component={BookDetailPage}/>
          <Route exact path={"/categories/:id"} component={CategoryBookPage}/>
          <Route exact path={"/categories"} component={CategoriesPage}/>
          <Route component={NotFoundPage}/>
        </Switch>
        <Navigation/>
      </Wrapper>
    </Background>
  );
}

export default App;
