import React, {ReactElement} from "react";
import {ReviewTypeBadge} from "../../components/badges/ReviewTypeBadge";
import {ScoreBadge} from "../../components/badges/ScoreBadge";
import Card from "../../components/card/Card";
import styled from "styled-components";
import {BookReview} from "../../interfaces";

interface Props {
  bookId?: string
  counts: number
  reviews: BookReview[]
}

function BookReviewCard({bookId, counts, reviews}: Props): ReactElement {
  return (
    <div>
      <Card backgroundColor='white'
            buttonText={counts > 3 ? '더보기' : undefined}
            buttonTo={`/books/${bookId}/reviews`}
            boxShadow='rgba(0, 0, 0, 0.24) 0px 3px 8px'>
        {reviews.map((bookReview: BookReview, index: number) => (
          <Wrapper key={index}>
            <ProfileWrapper>
              <ProfileImage src={bookReview.member.profileUrl}/>
            </ProfileWrapper>
            <ReviewWrapper>
              <FirstLine>
                <div style={{fontWeight: 'bold', fontSize: 'medium'}}>{bookReview.member.name}</div>
                <ReviewTypeBadge type={bookReview.reviewType} link={bookReview.blogContentUrl}/>
              </FirstLine>
              <SecondLine>
                <ScoreBadge rate={bookReview.rate}/>
              </SecondLine>
              <div>{bookReview.content}</div>
            </ReviewWrapper>
          </Wrapper>
        ))}
      </Card>
    </div>
  )
}

export default BookReviewCard

const Wrapper = styled.div`
  display: flex;
  flex-direction: row;
  width: 100%;
  margin-bottom: 2rem;
`

const ProfileWrapper = styled.div`
  flex: 1;
  margin-right: 1rem;
`

const ProfileImage = styled.img`
  border-radius: 50%;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
  width: 100%;
`

const ReviewWrapper = styled.div`
  flex: 5
`

const FirstLine = styled.div`
  display: flex;
  flex-direction: row;
  width: 100%;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 4px;
`

const SecondLine = styled.div`
  display: flex;
  flex-direction: row;
  width: 100%;
  justify-content: flex-end;
  margin-bottom: 0.5rem;
`

const LoadMoreReviewButton = styled.div`
  width: 100%;
  height: 4rem;
  background-color: black;
`