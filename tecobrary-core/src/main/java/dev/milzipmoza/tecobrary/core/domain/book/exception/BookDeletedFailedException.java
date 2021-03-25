package dev.milzipmoza.tecobrary.core.domain.book.exception;

public class BookDeletedFailedException extends BookException {

    public BookDeletedFailedException() {
        super();
    }

    public BookDeletedFailedException(String message) {
        super(message);
    }

    public BookDeletedFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookDeletedFailedException(Throwable cause) {
        super(cause);
    }

    protected BookDeletedFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
