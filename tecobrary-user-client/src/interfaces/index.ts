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

export interface BookTechDetail {
  mainTech: string
  additionalTech: string[]
  mainVersion: string
  versionDependency: string
}

export interface BookDetail {
  id: number
  imageUrl: string
  title: string
  author: string
  publisher: string
  description: string
  publishDate: string
  categories: Category[]
  like: BookLike
  bookMark: BookMarked
  techDetail?: BookTechDetail
}

export interface BookReview {
  id: number
  member: BookReviewMember
  reviewType: string
  content: string
  rate: number
}

export interface BookReviewMember {
  name: string
  profileUrl: string
}