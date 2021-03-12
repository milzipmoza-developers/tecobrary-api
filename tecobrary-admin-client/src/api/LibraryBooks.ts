import api from './index';
import {
  LibraryBookBasicInfo,
  LibraryBookDetailData,
  LibraryBookElement,
  LibraryBookEnrollRequest, LibraryBookPage, LibraryBookPageRequest
} from "../interfaces/LibraryBook";

export const getPageLibraryBooks = async ({page, size}: LibraryBookPageRequest) => {
  const response = await api.get('/admin/library-books', {
    params: {page, size}
  });
  return response.data
};

export const getLibraryBookDetail = async (id: string) => {
  const response = await api.get(`/admin/library-books/${id}`);
  return response.data;
}

export const libraryBookDetail: LibraryBookDetailData = {
  id: 6,
  title: "객체지향의 사실과 오해",
  image: "http://image.kyobobook.co.kr/images/book/xlarge/766/x9788998139766.jpg",
  author: "조영호",
  publisher: "위키북스",
  isbn: "12345678 ABCDEFG",
  description: "지금까지 이런 객체지향은 없었다.",
  books: [
    {
      bookSerial: "1",
      bookStatus: "IN_LIBRARY",
    },
    {
      bookSerial: "2",
      bookStatus: "RENT",
      rentMember: "루피",
      rentDateTime: '2020-01-02 17:00:00'
    },
    {
      bookSerial: "3",
      bookStatus: "IN_LIBRARY",
    },
    {
      bookSerial: "4",
      bookStatus: "RENT",
      rentMember: "루피",
      rentDateTime: '2020-01-02 17:00:00'
    },
    {
      bookSerial: "5",
      bookStatus: "IN_LIBRARY",
    },
    {
      bookSerial: "6",
      bookStatus: "RENT",
      rentMember: "루피",
      rentDateTime: '2020-01-02 17:00:00'
    },
    {
      bookSerial: "7",
      bookStatus: "IN_LIBRARY",
    },
    {
      bookSerial: "8",
      bookStatus: "IN_LIBRARY",
    },
  ]
}

export const enrollLibraryBook = async (book: LibraryBookEnrollRequest) => {
  const response = await api.put("/admin/library-books", {
    ...book
  });
  return response.data
}