import {atom, selector} from "recoil";

type alertType = 'success' | 'info' | 'warning' | 'error' | undefined;

export function alertDefault(message: string, type: alertType) {
  return {
    message,
    type
  }
}

export const alertState = atom({
  key: 'alertState',
  default: alertDefault('', undefined)
})

export const alertSelector = selector({
  key: 'alertSelector',
  get: ({get}) => {
    const alert = get(alertState);
    const showAlert = alert.type && alert.message.length !== 0;
    if (!showAlert) {
      console.debug(`check your alert trigger. type=${alert.type} message=${alert.message}`)
    }
    return showAlert;
  }
})