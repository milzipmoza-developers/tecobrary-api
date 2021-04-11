import {ReactElement, useState} from "react";
import Card from "../../../components/card/Card";
import {InterestCardNavigation} from "./InterestCardNavigation";

function InterestCard(): ReactElement {

  return (
    <Card backgroundColor='white'
          boxShadow='rgba(0, 0, 0, 0.24) 0px 3px 8px'>
      <InterestCardNavigation buttonNames={['리뷰', '좋아요', '북마크']}/>
    </Card>
  )
}

export default InterestCard
