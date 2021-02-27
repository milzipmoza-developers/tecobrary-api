import {Book} from "./Book";

export interface LibraryBookElement {
  id: number;
  title: string;
  author: string;
  publisher: string;
  isbn: string;
  categories: string[];
}

export interface LibraryBookSearch {
  title: string;
  author: string;
  publisher: string;
}

export interface LibraryBookDetail {
  id: number;
  title: string;
  image: string;
  author: string;
  publisher: string;
  isbn: string;
  description: string;
  books: Book[];
}

export interface LibraryBookEdit {
  title?: string;
  image?: string;
  author?: string;
  publisher?: string;
  description?: string;
}

export interface LibraryBookSearchData {
  total: number;
  start: number;
  display: number;
  items: LibraryBookSearchItem[]
}

export interface LibraryBookSearchItem {
  title: string;
  author: string;
  publisher: string;
  isbn: string;
  image: string;
  description: string;
}

export interface LibraryBookPage {

}