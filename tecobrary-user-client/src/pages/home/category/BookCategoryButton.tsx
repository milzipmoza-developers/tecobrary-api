import {ReactElement} from "react";
import styled from "styled-components";

interface Props {
  imgSrc: string
  name: string
  onClick: () => void
}

export const BookCategoryButton = ({imgSrc, name, onClick}: Props): ReactElement => {
  return (
    <CategoryElement onClick={onClick}>
      <CategoryContent>
        <LogoWrapper>
          <img src={imgSrc} width='100%'/>
        </LogoWrapper>
        <NameWrapper>
          <div>{name}</div>
        </NameWrapper>
      </CategoryContent>
    </CategoryElement>
  )
}

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