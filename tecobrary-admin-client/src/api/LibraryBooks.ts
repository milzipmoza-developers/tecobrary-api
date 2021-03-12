import api from './index';
import {
  LibraryBookBasicInfo,
  LibraryBookDetailData,
  LibraryBookElement,
  LibraryBookEnrollRequest, LibraryBookPage, LibraryBookPageRequest, LibraryBookUpdateRequest
} from "../interfaces/LibraryBook";

export const requestPageLibraryBooks = async ({page, size}: LibraryBookPageRequest) => {
  const response = await api.get('/admin/library-books', {
    params: {page, size}
  });
  return response.data;
};

export const requestLibraryBookDetail = async (id: string) => {
  const response = await api.get(`/admin/library-books/${id}`);
  return response.data;
}

export const requestEnrollLibraryBook = async (book: LibraryBookEnrollRequest) => {
  const response = await api.put("/admin/library-books", {
    ...book
  });
  return response.data;
}

export const requestUpdateLibraryBook = async (id: string, book: LibraryBookUpdateRequest) => {
  const response = await api.post(`/admin/library-books/${id}`, {
    ...book
  });
  return response.data;
}