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
  id: number
  title: string
  image: string
  author: string
  publisher: string
  isbn: string
  description: string
  books: Book[]
}

export interface LibraryBookPage {

}