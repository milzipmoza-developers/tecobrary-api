import {ReactElement} from "react";
import {CategoryBadges} from "../badges/CategoryBadges";
import styled from "styled-components";
import {Tag} from "../../interfaces";
import {useHistory} from "react-router-dom";

interface Props {
  id: number
  imageUrl: string
  title: string
  author: string
  categories?: Tag[]
  iconBadge?: ReactElement
  itemOnClick?: (id: number) => void
}

export const CardBookListElement = ({
                                      id,
                                      imageUrl,
                                      title,
                                      author,
                                      categories,
                                      iconBadge,
                                      itemOnClick
                                    }: Props): ReactElement => {
  const history = useHistory()

  const onClick = () => {
    history.push(`/books/${id}`)
  }

  return (
    <Element onClick={itemOnClick ? () => itemOnClick(id) : onClick}>
      <ElementImage src={imageUrl}/>
      <ElementContent>
        <ElementTitle>{title}</ElementTitle>
        <ElementLine>
          {categories
            ? <CategoryBadges categories={categories} size='small' maxLength={3}/>
            : null}
          <ElementAuthor>{author}</ElementAuthor>
        </ElementLine>
        {iconBadge
          ? <ElementLastLine>{iconBadge}</ElementLastLine>
          : null}
      </ElementContent>
    </Element>
  )
}


const Element = styled.div`
  height: 6rem;
  width: 100%;
  display: flex;
  flex-direction: row;
  margin-bottom: 1rem;
  cursor: pointer;
  align-items: center;
`

const ElementImage = styled.img`
  width: 4rem;
  border-radius: 10%;
  box-shadow: rgba(60, 64, 67, 0.3) 0px 1px 2px 0px, rgba(60, 64, 67, 0.15) 0px 1px 3px 1px;
  margin-right: 1rem;
`

const ElementContent = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
`

const ElementTitle = styled.div`
  font-size: small;
  font-weight: bold;
  width: 100%;
`

const ElementLine = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  width: 100%;
  margin-top: auto;
`

const ElementAuthor = styled.div`
  font-size: small;
  font-weight: lighter;
  margin-left: auto;
`

const ElementLastLine = styled.div`
  display: flex;
  flex-direction: row;
  margin-top: auto;
  justify-content: flex-end;
`