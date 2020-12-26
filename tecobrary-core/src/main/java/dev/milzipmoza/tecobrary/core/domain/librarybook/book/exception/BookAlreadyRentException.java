package dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception;

public class BookAlreadyRentException extends BookException {

    public BookAlreadyRentException() {
        super();
    }

    public BookAlreadyRentException(String message) {
        super(message);
    }

    public BookAlreadyRentException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookAlreadyRentException(Throwable cause) {
        super(cause);
    }

    protected BookAlreadyRentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
