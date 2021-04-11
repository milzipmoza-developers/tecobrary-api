import {ReactElement, useState} from "react";
import {PageFrame} from "../../components/page/PageFrame";
import {Category, NewBook} from "../../interfaces";
import {getBookCategories, getNewArrivalBooks} from "../../api/home";
import SpannedCard from "../../components/card/SpannedCard";
import Plain from "../../components/plain/Plain";
import {HomeNewBookCarousel} from "./newbook/HomeNewBookCarousel";
import InterestCard from "./interest/InterestCard";
import {PageContent} from "../../components/page/PageContent";
import BookCategories from "./category/BookCategories";

function HomePage(): ReactElement {

  const [newArrivalBooks] = useState<NewBook[]>(getNewArrivalBooks)
  const [categories] = useState<Category[]>(getBookCategories)

  return (
    <PageFrame top='8rem'>
      <SpannedCard title='새로운 도서를 살펴보세요'>
        <HomeNewBookCarousel books={newArrivalBooks}/>
      </SpannedCard>
      <PageContent style={{margin: '3rem 0 3rem 0'}}>
        <Plain title='카테고리로 찾아보세요'
               titleMargin='0 2rem 0 2rem'>
          <BookCategories categories={categories}/>
        </Plain>
      </PageContent>
      <PageContent style={{margin: '3rem 1rem 3rem 1rem'}}>
        <Plain title='관심 받는 도서들이 있어요'>
          <InterestCard/>
        </Plain>
      </PageContent>
    </PageFrame>
  )
}

export default HomePage
