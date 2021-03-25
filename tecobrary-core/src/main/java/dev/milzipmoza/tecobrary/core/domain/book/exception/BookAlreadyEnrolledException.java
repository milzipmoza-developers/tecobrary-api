package dev.milzipmoza.tecobrary.core.domain.book.exception;

public class BookAlreadyEnrolledException extends BookException {

    public BookAlreadyEnrolledException() {
        super();
    }

    public BookAlreadyEnrolledException(String message) {
        super(message);
    }

    public BookAlreadyEnrolledException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookAlreadyEnrolledException(Throwable cause) {
        super(cause);
    }
}
