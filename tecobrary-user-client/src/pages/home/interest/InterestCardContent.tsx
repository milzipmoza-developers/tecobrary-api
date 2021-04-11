import {ReactElement} from "react";
import {useRecoilValue} from "recoil";
import {homeInterestState} from "../../../states/Home";
import {InterestReviewContent} from "./InterestReviewContent";
import {InterestLikeContent} from "./InterestLikeContent";
import {InterestBookmarkContent} from "./InterestBookmarkContent";

export const InterestCardContent = (): ReactElement => {

  const home = useRecoilValue(homeInterestState)

  const SelectableContent = () => {
    if (home.selected === 0) {
      return <InterestReviewContent/>
    }
    if (home.selected === 1) {
      return <InterestLikeContent/>
    }
    if (home.selected === 2) {
      return <InterestBookmarkContent/>
    }
    return null
  }

  return <SelectableContent/>
}