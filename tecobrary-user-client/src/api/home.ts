import {Category, NewBook} from "../interfaces";

export const getNewArrivalBooks: NewBook[] = [
  {
    id: 1,
    imageUrl: "http://image.kyobobook.co.kr/images/book/xlarge/727/x9788960883727.jpg",
    title: "오늘도 개발자가 안 된다고 말했다",
    author: "김중철, 김수지",
    publisher: "디지털북스",
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
  },
  {
    id: 2,
    imageUrl: "http://image.kyobobook.co.kr/images/book/xlarge/766/x9788998139766.jpg",
    title: "객체지향의 사실과 오해",
    author: "조영호",
    publisher: "위키북스",
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
  },
  {
    id: 2,
    imageUrl: "http://image.kyobobook.co.kr/images/book/xlarge/670/x9788966262670.jpg",
    title: "실전 리액트 프로그래밍 리액트 훅부터 Next.js까지 개정판",
    author: "이재승",
    publisher: "인사이트",
    categories: [
      {
        name: 'IT',
        color: getRandomColor()
      },
      {
        name: '입문서',
        color: getRandomColor()
      },
      {
        name: 'React',
        color: getRandomColor()
      },
      {
        name: 'javascript',
        color: getRandomColor()
      }
    ]
  }
]


export function getRandomColor(): string {
  const letters = '0123456789ABCDEF';
  let color = '#';
  for (let i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}