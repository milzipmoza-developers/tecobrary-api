import {Book} from "./Book";

export interface LibraryBookElement {
  id: number;
  title: string;
  author: string;
  publisher: string;
  isbn: string;
  counts: number;
}

export interface LibraryBookSearch {
  title: string;
  author: string;
  publisher: string;
}

export interface LibraryBookSearchData {
  total: number;
  start: number;
  display: number;
  items: LibraryBookSearchItem[]
}

export interface LibraryBookBasicInfo {
  title: string;
  author: string;
  publisher: string;
  isbn: string;
  image: string;
  description: string;
}

export interface LibraryBookEnrollRequest extends LibraryBookBasicInfo {

}

export interface LibraryBookEnrollData extends LibraryBookBasicInfo {
  id: number;
  title: string;
  author: string;
  publisher: string;
  isbn: string;
  image: string;
  description: string;
}

export interface LibraryBookUpdateRequest {
  title: string;
  image: string;
  author: string;
  publisher: string;
  description: string;
}

export interface LibraryBookEdit extends LibraryBookUpdateRequest{
  title: string;
  image: string;
  author: string;
  publisher: string;
  description: string;
}

export interface LibraryBookUpdateData extends LibraryBookBasicInfo {
  id: number;
  title: string;
  author: string;
  publisher: string;
  isbn: string;
  image: string;
  description: string;
}

export interface LibraryBookDetailData extends LibraryBookBasicInfo {
  id: number;
  title: string;
  image: string;
  author: string;
  publisher: string;
  isbn: string;
  description: string;
  books: Book[];
}
export interface LibraryBookSearchItem extends LibraryBookBasicInfo {
  title: string;
  image: string;
  author: string;
  publisher: string;
  isbn: string;
  description: string;
}

export interface LibraryBookPageRequest {
  page: number;
  size: number;
}

export interface LibraryBookPageData {
  books: LibraryBookElement[];
}

export interface LibraryBookPage {

}