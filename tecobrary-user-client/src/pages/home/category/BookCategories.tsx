import {ReactElement} from "react";
import {Category} from "../../../interfaces";
import styled from "styled-components";
import "./book-categories.css";
import {BookCategoryButton} from "./BookCategoryButton";
import {useHistory} from "react-router-dom";

interface Props {
  categories: Category[]
}

function BookCategories({categories}: Props): ReactElement {
  const history = useHistory()

  const onClick = (name: string) => () => {
    history.push(`/books?category=${name}`)
  }

  const moreCategoriesOnClick = () => {
    history.push(`/categories`)
  }

  return (
    <Wrapper>
      <CategoryElements className='scroll-hidden'>
        {categories.map((category: Category, index: number) => (
          <BookCategoryButton key={index} name={category.displayName} imgSrc={category.logoUrl} onClick={onClick(category.name)}/>
        ))}
        <BookCategoryButton name='더보기'
                            imgSrc='https://tecobrary-pivot.s3.ap-northeast-2.amazonaws.com/logos/more.png'
                            onClick={moreCategoriesOnClick}/>
      </CategoryElements>
    </Wrapper>
  )
}

export default BookCategories

const Wrapper = styled.div`
  height: fit-content;
  width: auto;
  display: flex;
  flex-direction: row;
  overflow-y: hidden;
`

const CategoryElements = styled.div`
  overflow-y: auto;
  display: flex;
  flex-direction: row;
  width: fit-content;
  padding: 1rem 1rem 1rem 1rem;
`

const CategoryElement = styled.div`
  width: 8rem;
  height: 8rem;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
  background-color: white;
  border-radius: 1.5rem;
  margin-right: 1rem;
`

const CategoryContent = styled.div`
  width: 8rem;
  height: 8rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`

const LogoWrapper = styled.div`
  display: flex;
  width: 4rem;
  height: 4rem;
  margin-bottom: 1rem;
  justify-content: center;
  align-items: center;
`

const NameWrapper = styled.div`
  font-weight: bold;
  font-size: small;
`