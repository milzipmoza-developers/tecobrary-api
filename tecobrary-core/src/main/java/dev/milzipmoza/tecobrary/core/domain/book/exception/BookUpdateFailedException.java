package dev.milzipmoza.tecobrary.core.domain.book.exception;

public class BookUpdateFailedException extends BookException {

    public BookUpdateFailedException() {
        super();
    }

    public BookUpdateFailedException(String message) {
        super(message);
    }

    public BookUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookUpdateFailedException(Throwable cause) {
        super(cause);
    }

    protected BookUpdateFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
