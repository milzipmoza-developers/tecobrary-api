package dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception;

public class BookRentFailedException extends BookException {

    public BookRentFailedException() {
        super();
    }

    public BookRentFailedException(String message) {
        super(message);
    }

    public BookRentFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookRentFailedException(Throwable cause) {
        super(cause);
    }

    protected BookRentFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
