import api from './index';
import {BookEnrollRequest} from "../interfaces/Book";

export const requestEnrollBook = async (id: string, body: BookEnrollRequest) => {
  const response = await api.put(`/admin/library-books/${id}/books`, {
    ...body
  });
  return response.data;
}