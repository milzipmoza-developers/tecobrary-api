import api from './index'

interface NaverBookSearchRequest {
  keyword: string;
  page: number;
  size: number;
}

export const searchNaverApiBooks = async({keyword, page, size}: NaverBookSearchRequest) => {
  const response = await api.get('/admin/naver-api/books', {
    params: { keyword, page, size }
  });
  return response.data
}