export interface Category {
  name: string
  color: string
}

export interface NewBook {
  id: number
  imageUrl: string
  title: string
  author: string
  publisher: string
  description: string
  categories: Category[]
  like: boolean
  bookMarked: boolean
}

export interface BookLike {
  liked: boolean,
  counts: number
}

export interface BookMarked {
  marked: boolean,
  counts: number
}

export interface BookDetail {
  id: number
  imageUrl: string
  title: string
  author: string
  publisher: string
  description: string
  categories: Category[]
  like: BookLike
  bookMark: BookMarked
}