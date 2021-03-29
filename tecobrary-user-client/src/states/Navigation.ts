import {atom} from "recoil";

interface NavigationState {
  selected: number;
}

const defaultNavigationState = (): NavigationState => ({
  selected: 1
});

export const navigationState = atom({
  key: "navigationState",
  default: defaultNavigationState()
});