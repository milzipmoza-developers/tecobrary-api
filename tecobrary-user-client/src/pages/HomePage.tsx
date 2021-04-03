import React, {ReactElement} from "react";
import Card from "../components/card/Card";
import PageFrame from "../components/page/PageFrame";
import {PageContent} from "../components/page/PageContent";
import Plain from "../components/plain/Plain";
import BookRankList from "../components/list/BookRankList";
import ReviewRankList from "../components/list/ReviewRankList";

function HomePage(): ReactElement {
  return (
    <PageFrame title="테코브러리">
      <PageContent>
        <Card title="새로운 도서를 살펴보세요"
              backgroundColor="#EAEBFF"
              buttonText="새로운 도서 구경하러가기"
              buttonTo="/timeline">
          새로운 도서 구경하기
        </Card>
      </PageContent>
      <PageContent>
        <Plain title="리뷰 확인하고 책을 읽어보세요"
               subTitle="사람들의 관심이 많은 책">
          <BookRankList/>
        </Plain>
      </PageContent>
      <PageContent>
        <Card title="이 달의 리뷰왕은 ?"
              backgroundColor="#FFFFD8"
              buttonText="내 순위 보러가기"
              buttonTo="/">
          <ReviewRankList/>
        </Card>
      </PageContent>
    </PageFrame>
  )
}

export default HomePage