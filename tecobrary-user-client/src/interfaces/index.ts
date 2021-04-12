export interface Tag {
  name: string
  color: string
}

export interface Category {
  id: number
  name: string
  displayName: string
  logoUrl: string
}

export interface NewBook {
  id: number
  imageUrl: string
  title: string
  author: string
}

export interface InterestedBooks {
  type: 'REVIEW' | 'LIKE' | 'BOOK_MARKED'
  books: InterestedBook[]
}

export interface Book {
  id: number
  imageUrl: string
  title: string
  author: string
  categories: Tag[]
}

export interface InterestedBook extends Book {
  id: number
  imageUrl: string
  title: string
  author: string
  categories: Tag[]
  counts: number
}

export interface ListBook extends Book {
  id: number
  imageUrl: string
  title: string
  author: string
  categories: Tag[]
  countDetail: BookInterestCount
}

export interface BookInterestCount {
  like: number
  review: number
  bookMarked: number
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
  categories: Tag[]
  like: BookLike
  bookMark: BookMarked
  techDetail?: BookTechDetail
}

export interface BookReview {
  id: number
  member: BookReviewMember
  reviewType: 'SHORT_REVIEW' | 'BLOG_IMPORT'
  content: string
  rate: number
  blogContentUrl?: string
}

export interface BookDetailReview {
  counts: number
  reviews: BookReview[]
}

export interface BookReviewMember {
  name: string
  profileUrl: string
}