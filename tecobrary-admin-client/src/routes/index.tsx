import {RouteMenuItem} from "../interfaces/RouteItem";
import IndexPage from "../pages/IndexPage";
import {BookOutlined, CarryOutOutlined, DatabaseOutlined, HomeOutlined, UserOutlined} from "@ant-design/icons";
import MemberPage from "../pages/member/MemberPage";
import LibraryBookPage from "../pages/libraryBook/LibraryBookPage";
import WishBookPage from "../pages/WishBookPage";
import RentPage from "../pages/RentPage";
import React from "react";
import LibraryBookDetailPage from "../pages/libraryBook/LIbraryBookDetailPage";
import LibraryBookEnrollPage from "../pages/libraryBook/LibraryBookEnrollPage";

export const routeItems: RouteMenuItem[] = [
  {
    isMenu: true,
    icon: <HomeOutlined/>,
    name: "홈",
    path: "/",
    component: IndexPage
  },
  {
    isMenu: true,
    icon: <UserOutlined/>,
    name: "회원관리",
    path: "/members",
    component: MemberPage
  },
  {
    isMenu: true,
    icon: <BookOutlined/>,
    parentName: "도서",
    menuItems: [
      {
        isMenu: true,
        name: "등록",
        path: "/library-books/enroll",
        component: LibraryBookEnrollPage
      },
      {
        isMenu: true,
        name: "조회 및 관리",
        path: "/library-books",
        component: LibraryBookPage
      },
    ]
  },
  {
    isMenu: false,
    icon: null,
    name: "도서 상세조회",
    path: "/library-books/:id",
    component: LibraryBookDetailPage
  },
  {
    isMenu: true,
    icon: <DatabaseOutlined/>,
    name: "희망도서관리",
    path: "/wish-books",
    component: WishBookPage
  },
  {
    isMenu: true,
    icon: <CarryOutOutlined/>,
    name: "대여내역",
    path: "/rents",
    component: RentPage
  },
]