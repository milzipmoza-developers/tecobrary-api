package dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception;

public class BookSerialNotFoundException extends BookException {
    public BookSerialNotFoundException() {
        super();
    }

    public BookSerialNotFoundException(String message) {
        super(message);
    }

    public BookSerialNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookSerialNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BookSerialNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
