import axios from "axios";

export default axios.create({
  baseURL: `${process.env.REACT_APP_TECOBRARY_API}`,
  timeout: parseInt(`${process.env.REACT_APP_TECOBRARY_API_TIMEOUT}`),
  headers: {
    'Content-Type': 'application/json'
  }
})