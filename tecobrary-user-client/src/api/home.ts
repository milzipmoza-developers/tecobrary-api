import {Category, NewBook} from "../interfaces";

export const getNewArrivalBooks: NewBook[] = [
  {
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
    like: true,
    bookMarked: false,
  },
  {
    id: 2,
    imageUrl: "http://image.kyobobook.co.kr/images/book/xlarge/766/x9788998139766.jpg",
    title: "객체지향의 사실과 오해",
    author: "조영호",
    publisher: "위키북스",
    description: `객체지향에 대한 선입견을 버려라!

『객체지향의 사실과 오해』는 객체지향이란 무엇인가라는 원론적면서도 다소 위험한 질문에 답하기 위해 쓰여진 책이다. 안타깝게도 많은 사람들이 객체지향의 본질을 오해하고 있다. 가장 널리 퍼져있는 오해는 클래스가 객체지향 프로그래밍의 중심이라는 것이다. 객체지향으로 향하는 첫 걸음은 클래스가 아니라 객체를 바라보는 것에서부터 시작한다. 객체지향으로 향하는 두 번째 걸음은 객체를 독립적인 존재가 아니라 기능을 구현하기 위해 협력하는 공동체의 일원으로 바라보는 것이다. 세 번째 걸음을 내디딜 수 있는지 여부는 협력에 참여하는 객체들에게 얼마나 적절한 역할과 책임을 부여할 수 있느냐에 달려 있다. 객체지향의 마지막 걸음은 앞에서 설명한 개념들을 프로그래밍 언어라는 틀에 흐트러짐 없이 담아낼 수 있는 기술을 익히는 것이다. 객체지향이란 무엇인가? 이 책은 이 질문에 대한 답을 찾기 위해 노력하고 있는 모든 개발자를 위한 책이다.`,
    categories: [
      {
        name: '객체지향',
        color: getRandomColor()
      },
      {
        name: '기본서',
        color: getRandomColor()
      },
      {
        name: '쉬움',
        color: getRandomColor()
      }
    ],
    like: true,
    bookMarked: false,
  },
]


export function getRandomColor(): string {
  const letters = '0123456789ABCDEF';
  let color = '#';
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}