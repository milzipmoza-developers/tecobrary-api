package dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception;

public class BookSerialAlreadyEnrolledException extends BookException {
    public BookSerialAlreadyEnrolledException() {
        super();
    }

    public BookSerialAlreadyEnrolledException(String message) {
        super(message);
    }

    public BookSerialAlreadyEnrolledException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookSerialAlreadyEnrolledException(Throwable cause) {
        super(cause);
    }

    protected BookSerialAlreadyEnrolledException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
