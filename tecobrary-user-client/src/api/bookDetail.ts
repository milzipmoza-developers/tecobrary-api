import {BookDetail} from "../interfaces";
import {getRandomColor} from "./home";

export const getBookDetail: BookDetail = {
  id: 1,
  imageUrl: "http://image.kyobobook.co.kr/images/book/xlarge/727/x9788960883727.jpg",
  title: "오늘도 개발자가 안 된다고 말했다",
  author: "김중철, 김수지",
  publisher: "디지털북스",
  description: `“개발하기 싫어서 안 된다고 말하는 게 아니다”
              “개발 언어를 잘 몰라도 협업을 잘할 수 있다”
              많은 IT 종사자들이 안 된다고 말하는 개발자로 인해 협업에 어려움을 겪는다. 우리는 IT 비전공자로서 소통을 잘하기 위해 개발자의 입장에서 많이 생각하게 됐고, 이 과정을 통해 개발자의 안 된다는 말에 담겨 있는 여러 가지 의미를 깨달았다. 이 책에는 우리의 성장 과정에서 발견한 협업 노하우들을 담아냈다.`,
  categories: [
    {
      name: 'IT',
      color: getRandomColor()
    },
    {
      name: '쉬움',
      color: getRandomColor()
    }
  ],
  like: {
    liked: true,
    counts: 10
  },
  bookMark: {
    marked: false,
    counts: 7
  }
}