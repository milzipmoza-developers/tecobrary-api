import React, {ReactElement, useEffect, useState} from "react";
import {useLocation} from "react-router-dom";
import {PageFrame} from "../../components/page/PageFrame";
import {PageContent} from "../../components/page/PageContent";
import Plain from "../../components/plain/Plain";
import ExpandableCard from "../../components/card/ExpandableCard";
import {CardBookList} from "../../components/list/CardBookList";
import {getBooks} from "../../api/books";
import {BookmarkedIcon} from "../../components/icons/BookmarkedIcon";
import {ReviewIcon} from "../../components/icons/ReviewIcon";
import {LikedIcon} from "../../components/icons/LikedIcon";

interface QueryParam {
  category: string | null
  keyword: string | null
  tag: string | null
}

function useQuery() {
  return new URLSearchParams(useLocation().search);
}

function BookListPage(): ReactElement {
  const query = useQuery()
  const [queryParam, setQueryParam] = useState<QueryParam>()
  const [books] = useState(getBooks)

  useEffect(() => {
    const category = query.get('category')
    const keyword = query.get('keyword')
    const tag = query.get('tag')
    setQueryParam({category, keyword, tag})
  }, [])

  const generateTitle = () => {
    if (queryParam?.category) {
      return `${queryParam.category} 에 관련된 도서 목록이예요`
    }
    if (queryParam?.keyword) {
      return `${queryParam.keyword} 에 관련된 도서 목록이예요`
    }
    if (queryParam?.tag) {
      return `${queryParam.tag} 에 관련된 도서 목록이예요`
    }
    return `도서 목록이예요`
  }

  return (
    <PageFrame top='8rem' header={true}>
      <PageContent>
        <Plain title={generateTitle()}
               margin='0 1rem 0 1rem'>
          <ExpandableCard backgroundColor='white'
                          boxShadow='rgba(0, 0, 0, 0.24) 0px 3px 8px'
                          buttonText='더보기'
                          buttonOnClick={() => console.log('더보기')}>
            {/*review, like, bookmark 순*/}
            <CardBookList iconBadge={[<ReviewIcon/>, <LikedIcon/>, <BookmarkedIcon/>]} books={books}/>
          </ExpandableCard>
        </Plain>
      </PageContent>
    </PageFrame>
  )
}

export default BookListPage
