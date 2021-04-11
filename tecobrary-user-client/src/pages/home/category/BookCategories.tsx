import {ReactElement} from "react";
import {Category} from "../../../interfaces";
import styled from "styled-components";

interface Props {
  categories: Category[]
}

function BookCategories({categories}: Props): ReactElement {
  return (
    <Wrapper>
      <CategoryElements>
        <Space/>
        {categories.map((category: Category, index: number) => (
          <CategoryElement key={index}>
            <CategoryContent>
              <LogoWrapper>
                <img src={category.logoUrl} width='100%'/>
              </LogoWrapper>
              <NameWrapper>
                <div>{category.name}</div>
              </NameWrapper>
            </CategoryContent>
          </CategoryElement>
        ))}
        <Space/>
      </CategoryElements>
    </Wrapper>
  )
}

export default BookCategories

const Wrapper = styled.div`
  height: fit-content;
  width: fit-content;
  display: flex;
  flex-direction: row;
  overflow-y: hidden;
`

const CategoryElements = styled.div`
  overflow-y: auto;
  display: flex;
  flex-direction: row;
  width: fit-content;
  padding: 2rem 0 1rem 0;
`

const Space = styled.div`
  width: 2rem;
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
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`

const LogoWrapper = styled.div`
  width: 4rem;
  height: 4rem;
  margin-bottom: 1rem;
`

const NameWrapper = styled.div`
  font-weight: bold;
  font-size: small;
`