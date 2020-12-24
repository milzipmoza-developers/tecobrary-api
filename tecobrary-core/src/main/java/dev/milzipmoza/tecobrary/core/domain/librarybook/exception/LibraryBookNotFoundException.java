package dev.milzipmoza.tecobrary.core.domain.librarybook.exception;

public class LibraryBookNotFoundException extends LibraryBookException {

    public LibraryBookNotFoundException(Long id) {
        super(String.format("id=%d 에 해당하는 도서를 찾을 수 없습니다.", id));
    }
}
