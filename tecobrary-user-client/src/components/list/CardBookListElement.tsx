import {ReactElement} from "react";
import {CategoryBadges} from "../badges/CategoryBadges";
import {CountedIconBadge} from "../badges/CountedIconBadge";
import {ReviewIcon} from "../icons/ReviewIcon";
import styled from "styled-components";
import {Tag} from "../../interfaces";
import {useHistory} from "react-router-dom";

interface Props {
  id: number
  imageUrl: string
  title: string
  author: string
  categories: Tag[]
  counts: number
  iconBadge: ReactElement
}

export const CardBookListElement = (props: Props): ReactElement => {
  const history = useHistory()

  const onClick = () => {
    history.push(`/books/${props.id}`)
  }

  return (
    <Element onClick={onClick}>
      <ElementImage src={props.imageUrl}/>
      <ElementContent>
        <ElementTitle>{props.title}</ElementTitle>
        <ElementLine>
          <CategoryBadges categories={props.categories} size='small' maxLength={3}/>
          <ElementAuthor>{props.author}</ElementAuthor>
        </ElementLine>
        <ElementLastLine>
          <CountedIconBadge counts={props.counts}>
            {props.iconBadge}
          </CountedIconBadge>
        </ElementLastLine>
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