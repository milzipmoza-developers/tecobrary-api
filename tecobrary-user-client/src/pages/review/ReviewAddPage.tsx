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
import Selector from "../../components/selector/Selector";
import {ReviewType} from "../../types";
import {CustomRadioButton} from "../../components/buttons/CustomRadioButton";
import {DisableableButton} from "../../components/buttons/DisableableButton";

interface Search {
  keyword: string
}

interface SelectedBook {
  selected: boolean
  book?: Book
}

interface SelectedAmount {
  value: string
  displayName: string
}

interface SelectedReview {
  type: ReviewType
  url?: string
  content?: string
}

const initSelectedBook = (): SelectedBook => ({
  selected: false
})

const initSelectedReview = (): SelectedReview => ({
  type: 'SHORT_REVIEW'
})

const selectBook = (book: Book): SelectedBook => ({
  selected: true,
  book
})

// todo: refactor this component to multiple components divided by rendering unit
function ReviewAddPage(): ReactElement {
  const [search, setSearch] = useState<Search>({keyword: ''})
  const [searchBooks, setSearchBooks] = useState<InternalSearchBook[]>([])
  const [selectedBook, setSelectedBook] = useState<SelectedBook>()
  const [selectedAmount, setSelectedAmount] = useState<SelectedAmount | null>()
  const [selectedReview, setSelectedReview] = useState(initSelectedReview)

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

  const onReviewUrlChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setSelectedReview({
      type: selectedReview.type,
      url: e.target.value
    })
  }

  const onItemClick = (id: number) => {
    const searchBook = getSearchBook(id);
    if (!searchBook) {
      throw Error('선택한 책이 존재하지 않습니다.')
    }
    setSelectedBook(selectBook(searchBook))
  }

  const onInitSelectBook = () => {
    setSearchBooks([])
    search.keyword = ''
    setSelectedReview(initSelectedReview)
    setSelectedAmount(null)
    setSelectedBook(initSelectedBook)
  }

  const onInitSelectAmount = () => {
    setSelectedReview(initSelectedReview)
    setSelectedAmount(null)
  }

  const onAmountChange = (it: SelectedAmount | null) => {
    if (it) {
      setSelectedAmount(it)
    }
  }

  const onReviewTypeChange = (it: ReviewType) => {
    setSelectedReview({
      ...selectedReview,
      type: it
    })
  }

  return (
    <PageFrame top='8rem' header={true}>
      <Plain title='도서를 선택해보세요'
             subTitle={selectedBook?.book ? undefined : '다 읽지 않아도 리뷰를 남길 수 있어요'}
             subTitleMargin='0 1rem 6px 1rem'
             margin='0 1rem 2rem 1rem'>
        {selectedBook?.book
          ? <Card backgroundColor='white'>
            <CardBookListElement id={selectedBook.book.id}
                                 imageUrl={selectedBook.book.imageUrl}
                                 title={selectedBook.book.title}
                                 author={selectedBook.book.author}
                                 categories={selectedBook.book.categories}/>
            <SelectInitButton onClick={onInitSelectBook}>다시 고르기</SelectInitButton>
          </Card>
          : <ExpandableCard backgroundColor='white'
                            boxShadow='rgba(0, 0, 0, 0.24) 0px 3px 8px'>
            <SearchWrapper>
              <SearchIconWrapper>
                <SearchOutline/>
              </SearchIconWrapper>
              <SearchInput placeholder='검색어로 도서를 찾아보세요'
                           value={search.keyword}
                           onChange={onChange}
                           autoFocus={true}/>
            </SearchWrapper>
            <SearchDivider/>
            <CardBookList books={searchBooks}
                          whenEmpty={<EmptyList/>}
                          itemOnClick={onItemClick}/>
          </ExpandableCard>}
      </Plain>
      {selectedBook?.selected
        ? <Plain title='얼마나 읽으셨나요?'
                 subTitle={selectedAmount ? undefined : '지금 읽은 만큼의 리뷰도 도움이 될 수 있어요'}
                 subTitleMargin='0 1rem 6px 1rem'
                 margin='0 1rem 2rem 1rem'>
          <Card backgroundColor='white'
                boxShadow={selectedAmount ? undefined : 'rgba(0, 0, 0, 0.24) 0px 3px 8px'}>
            {selectedAmount ?
              <ReadAmountWrapper>
                <ReadAmountSelected>{selectedAmount.displayName}</ReadAmountSelected>
                <SelectInitButton onClick={onInitSelectAmount}>다시 고르기</SelectInitButton>
              </ReadAmountWrapper>
              : <Selector placeholder='이만큼 읽었어요'
                          items={[
                            {value: 'ABSTRACT', displayName: '서론만 읽었어요'},
                            {value: 'LITTLE', displayName: '조금 읽어봤어요'},
                            {value: 'ONE_CHAPTER', displayName: '한 챕터 읽었어요'},
                            {value: 'CHAPTERS', displayName: '여러 챕터 읽었어요'},
                            {value: 'ALL', displayName: '전부 읽었어요'},
                          ]}
                          onChange={onAmountChange}/>}
          </Card>
        </Plain>
        : null}
      {selectedAmount
        ? <Plain title='어떤 책이었나요?'
                 subTitle='블로그에서 리뷰를 가져올 수 있어요'
                 subTitleMargin='0 1rem 6px 1rem'
                 margin='0 1rem 3rem 1rem'>
          <Card backgroundColor='white'
                boxShadow='rgba(0, 0, 0, 0.24) 0px 3px 8px'>
            <CustomRadioButton marginBottom='1rem'
                               onChange={onReviewTypeChange}/>
            {selectedReview.type === 'SHORT_REVIEW'
              ? <ReviewInputWrapper>
                <ReviewContentInput placeholder='리뷰를 10자 이상 입력해주세요'/>
              </ReviewInputWrapper>
              : <ReviewInputWrapper>
                <ReviewUrlInput placeholder='블로그 주소를 입력해주세요'
                                value={selectedReview.content}
                                onChange={onReviewUrlChange}/>
              </ReviewInputWrapper>}
          </Card>
        </Plain>
        : null}
      {selectedReview.content || selectedReview.url
        ? <Plain margin='0 2rem 2rem 2rem'>
          <DisableableButton name='리뷰를 다 작성했어요'
                             disabled={(selectedReview.content !== undefined && selectedReview.content.length < 10)
                             || (selectedReview.url !== undefined && selectedReview.url.length < 10)}
                             onClick={() => console.log('제출하기')}/>
        </Plain>
        : null
      }
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

const ReadAmountWrapper = styled.div`
  width: auto;
  height: 3rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`

const ReadAmountSelected = styled.div`
  font-size: large;
`

const ReviewInputWrapper = styled.div`
  width: auto;
  height: fit-content;
  padding: 1rem;
`

const ReviewUrlInput = styled.input`
  border-top: none;
  border-left: none;
  border-right: none;
  border-bottom: 1px solid rgba(0, 0, 0, 0.1);
  font-size: medium;
  width: 100%;

  &:focus {
    outline: none;
  }
`
const ReviewContentInput = styled.input`
  border: none;
  box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
  font-size: medium;
  width: 100%;
  resize: none;

  &:focus {
    outline: none;
    box-shadow: rgba(0, 0, 0, 0.02) 0px 1px 3px 0px, rgba(27, 31, 35, 0.15) 0px 0px 0px 1px;
  }
`