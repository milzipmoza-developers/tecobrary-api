import {ReactElement, useState} from "react";
import {PageFrame} from "../../components/page/PageFrame";
import {NewBook} from "../../interfaces";
import {getNewArrivalBooks} from "../../api/home";
import SpannedCard from "../../components/card/SpannedCard";
import Plain from "../../components/plain/Plain";
import {HomeNewBookCarousel} from "./newbook/HomeNewBookCarousel";
import InterestCard from "./interest/InterestCard";

function HomePage(): ReactElement {

  const [newArrivalBooks] = useState<NewBook[]>(getNewArrivalBooks)

  return (
    <PageFrame top='8rem'>
      <SpannedCard title='새로운 도서를 살펴보세요'>
        <HomeNewBookCarousel books={newArrivalBooks}/>
      </SpannedCard>
      <Plain title='관심 받는 도서들이 있어요'
             margin='3rem 1rem 3rem 1rem'>
        <InterestCard/>
      </Plain>
    </PageFrame>
  )
}

export default HomePage