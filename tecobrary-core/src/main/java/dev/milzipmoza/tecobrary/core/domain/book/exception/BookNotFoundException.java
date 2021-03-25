package dev.milzipmoza.tecobrary.core.domain.book.exception;

public class BookNotFoundException extends BookException {

    public BookNotFoundException(Long id) {
        super(String.format("id=%d 에 해당하는 도서를 찾을 수 없습니다.", id));
    }
}
