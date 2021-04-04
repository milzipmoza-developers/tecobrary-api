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
