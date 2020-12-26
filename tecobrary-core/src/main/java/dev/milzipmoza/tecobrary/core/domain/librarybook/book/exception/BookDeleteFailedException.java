package dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception;

public class BookDeleteFailedException extends BookException {

    public BookDeleteFailedException() {
        super();
    }

    public BookDeleteFailedException(String message) {
        super(message);
    }

    public BookDeleteFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookDeleteFailedException(Throwable cause) {
        super(cause);
    }

    protected BookDeleteFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
