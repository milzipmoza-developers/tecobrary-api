import {ReactElement} from "react";
import {CategoryBadge} from "./CategoryBadge";
import styled from "styled-components";
import {Category} from "../../interfaces";

interface Props {
  categories: Category[]
}

export const CategoryBadges = ({categories}: Props): ReactElement => (
  <Wrapper>
    {categories.map((it: Category, index: number) => (
      <CategoryBadge key={index} backgroundColor={it.color}>{it.name}</CategoryBadge>))}
  </Wrapper>
)

const Wrapper = styled.div`
  width: auto;
  height: fit-content;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  margin: 0.5rem 0 1rem 0;
`