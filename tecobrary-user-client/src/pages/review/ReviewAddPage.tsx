import React, {ReactElement, useEffect, useState} from "react";
import {PageFrame} from "../../components/page/PageFrame";
import Plain from "../../components/plain/Plain";
import {CardBookList} from "../../components/list/CardBookList";
import styled from "styled-components";
import {SearchOutline} from "react-ionicons";
import {getSearchBook, getSearchBooks} from "../../api/search";
import {Book, InternalSearchBook} from "../../interfaces";
import ExpandableCard from "../../components/card/ExpandableCard";
import {CardBookListElement} from "../../components/list/CardBookListElement";
import Card from "../../components/card/Card";

interface Search {
  keyword: string
}

interface SelectedBook {
  selected: boolean
  book?: Book
}

const initSelectedBook = (): SelectedBook => {
  return {
    selected: false
  }
}

const selectBook = (book: Book): SelectedBook => {
  return {
    selected: true,
    book
  }
}

function ReviewAddPage(): ReactElement {
  const [search, setSearch] = useState<Search>({keyword: ''})
  const [searchBooks, setSearchBooks] = useState<InternalSearchBook[]>([])
  const [selected, setSelected] = useState<SelectedBook>()

  useEffect(() => {
    if (search.keyword.length < 2) {
      setSearchBooks([])
    }
    if (search.keyword.length >= 2) {
      console.log('search request', search.keyword) // todo: remove
      setSearchBooks(getSearchBooks)
    }
  }, [search])

  const onChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSearch({
      keyword: e.target.value
    })
  }

  const onItemClick = (id: number) => {
    console.log(id)
    const searchBook = getSearchBook(id);
    if (!searchBook) {
      throw Error('선택한 책이 존재하지 않습니다.')
    }
    setSelected(selectBook(searchBook))
  }

  const onInitSelectedBook = () => {
    setSearchBooks([])
    search.keyword = ''
    setSelected(initSelectedBook)
  }

  return (
    <PageFrame top='8rem' header={true}>
      <Plain title='도서를 선택해보세요'
             subTitle='다 읽지 않아도 리뷰를 남길 수 있어요'
             subTitleMargin='0 1rem 6px 1rem'
             margin='0 1rem 2rem 1rem'>
        {!selected?.book
          ? <ExpandableCard backgroundColor='white'
                            boxShadow='rgba(0, 0, 0, 0.24) 0px 3px 8px'>
            <SearchWrapper>
              <SearchIconWrapper>
                <SearchOutline/>
              </SearchIconWrapper>
              <SearchInput placeholder='검색어로 도서를 찾아보세요'
                           value={search.keyword}
                           onChange={onChange}/>
            </SearchWrapper>
            <SearchDivider/>
            <CardBookList books={searchBooks}
                          whenEmpty={<EmptyList/>}
                          itemOnClick={onItemClick}/>
          </ExpandableCard>
          : <Card backgroundColor='white'>
            <CardBookListElement id={selected.book.id}
                                 imageUrl={selected.book.imageUrl}
                                 title={selected.book.title}
                                 author={selected.book.author}
                                 categories={selected.book.categories} />
            <SelectInitButton onClick={onInitSelectedBook}>다시 고르기</SelectInitButton>
          </Card>}
      </Plain>
    </PageFrame>
  )
}

export default ReviewAddPage

const SearchWrapper = styled.div`
  display: flex;
  flex-direction: row;
  margin-bottom: 1rem;
`

const SearchIconWrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 0 2px 0 2px;
`

const SearchDivider = styled.div`
  width: auto;
  height: 1px;
  background-color: #ecf0f1;
  margin-bottom: 1rem;
`

const SearchInput = styled.input`
  border: none;
  font-size: medium;
  width: 100%;

  &:focus {
    outline: none;
  }
`

const EmptyList = styled.div``

const SelectInitButton = styled.div`
  background-color: black;
  color: white;
  width: fit-content;
  font-size: x-small;
  padding: 4px;
  border-radius: 1rem;
  margin-left: auto;
`