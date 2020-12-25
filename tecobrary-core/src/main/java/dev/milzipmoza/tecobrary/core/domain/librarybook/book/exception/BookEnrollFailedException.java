package dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception;

public class BookEnrollFailedException extends BookException {

    public BookEnrollFailedException() {
        super();
    }

    public BookEnrollFailedException(String message) {
        super(message);
    }

    public BookEnrollFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookEnrollFailedException(Throwable cause) {
        super(cause);
    }

    protected BookEnrollFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
