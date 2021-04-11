import {BookDetail, BookReview} from "../interfaces";
import {getRandomColor} from "./home";

export const getBookDetail: Map<number, BookDetail> = new Map([
  [1, {
    id: 1,
    imageUrl: "http://image.kyobobook.co.kr/images/book/xlarge/727/x9788960883727.jpg",
    title: "오늘도 개발자가 안 된다고 말했다",
    author: "김중철, 김수지",
    publisher: "디지털북스",
    description: `“개발하기 싫어서 안 된다고 말하는 게 아니다”
              “개발 언어를 잘 몰라도 협업을 잘할 수 있다”
              많은 IT 종사자들이 안 된다고 말하는 개발자로 인해 협업에 어려움을 겪는다. 우리는 IT 비전공자로서 소통을 잘하기 위해 개발자의 입장에서 많이 생각하게 됐고, 이 과정을 통해 개발자의 안 된다는 말에 담겨 있는 여러 가지 의미를 깨달았다. 이 책에는 우리의 성장 과정에서 발견한 협업 노하우들을 담아냈다.`,
    publishDate: "2021-03-25",
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
  }],
  [2, {
    id: 2,
    imageUrl: "http://image.kyobobook.co.kr/images/book/xlarge/670/x9788966262670.jpg",
    title: "실전 리액트 프로그래밍 리액트 훅부터 Next.js까지 개정판",
    author: "이재승",
    publisher: "인사이트",
    description: `핵심 원리로 리액트의 기본 개념을 다지고,
리액트 훅으로 구현된 실전 예제를 통해 활용법을 익힌다!
리액트 훅으로 작성된 예제와 핵심 원리를 통해 리액트의 실전 사용법을 익힐 수 있다. 단순히 기술을 소개하는 데 그치지 않고 그 기술을 사용하는 이유를 함께 다룬다. 따라서 리액트뿐 아니라 앞으로 만나게 될 어떤 기술도 빠르게 배울 수 있는 기본기를 쌓을 수 있다. 리액트를 이미 사용해 본 사람을 대상으로 쓰였지만 기초부터 시작한다. 우선 리액트 프로젝트를 구축하고, 최신 자바스크립트 문법, 리액트의 주요 개념을 간단히 알아본다. 클래스형 컴포넌트를 설명하는 부분을 제외하고 이 책의 모든 예제는 리액트 훅으로 작성했다.

리액트 훅의 개념과 실제 활용할 때 도움이 되는 고급 활용법을 알아본 후 리덕스, 바벨, 웹팩까지 다룬다. 서버사이드 렌더링의 개념과 Next.js 프로젝트를 구축하는 방법을 살펴본 후 타입스크립트를 이용해 리액트 코드를 작성한다. 추후 리액트에 추가될 것으로 예상되는 concurrent 모드까지 다뤄서 다가올 변화에도 대비한다.`,
    publishDate: "2020-07-13",
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
    ],
    like: {
      liked: true,
      counts: 10
    },
    bookMark: {
      marked: false,
      counts: 7
    },
    techDetail: {
      mainTech: "React",
      additionalTech: ["Next.js", "Redux", "JSX"],
      mainVersion: "16.x.x",
      versionDependency: "HIGH",
    }
  }]
])

export const getBookReviews: BookReview[] = [
  {
    id: 1,
    member: {
      name: "개발왕루피",
      profileUrl: "https://avatars.githubusercontent.com/u/52121827?v=4"
    },
    reviewType: 'SHORT_REVIEW',
    content: '이 책은 매우 좋은 책',
    rate: 3
  },
  {
    id: 2,
    member: {
      name: "개발왕루피",
      profileUrl: "https://avatars.githubusercontent.com/u/52121827?v=4"
    },
    reviewType: 'BLOG_IMPORT',
    content: '책임-주도 설계는 어떤 메시지들이 필요한지를 먼저 뽑은 후에, 어떤 객체가 각각의 책임을 지면 좋을지를 생각하면서 협력을 만들어내는 것이다. 메시지를 결정하기 전 까지는 객체에 관한 생각을 일단 하지 않는다. 의도적으로 가장 추상적인 레벨에서 필요한 메시지를 우선 완성하는 것이다. 이러한 메시지들이 결정된 후에야 이 메시지를 처리할 객체에 매핑 시키며 협력을 만들어낸다.',
    rate: 4,
    blogContentUrl: 'https://velog.io/@aidenshin/%EA%B0%9D%EC%B2%B4%EC%A7%80%ED%96%A5%EC%9D%98-%EC%82%AC%EC%8B%A4%EA%B3%BC-%EC%98%A4%ED%95%B4-%EB%A6%AC%EB%B7%B0'
  },
]