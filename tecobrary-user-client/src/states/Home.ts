import {atom} from "recoil";

interface HomeInterestState {
  selected: number
}

const defaultHomeInterestState = (): HomeInterestState => ({
  selected: 0
})

export const homeInterestState = atom({
  key: 'homeInterestState',
  default: defaultHomeInterestState()
})