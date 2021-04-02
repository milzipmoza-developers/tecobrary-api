import {atom} from "recoil";

interface UserInfo {
  name: string
}

interface UserState {
  loggedIn: boolean
  userInfo: UserInfo | null
}

const defaultUserState = (): UserState => ({
  loggedIn: false,
  userInfo: null
})

export const userState = atom({
  key: "userState",
  default: defaultUserState()
})