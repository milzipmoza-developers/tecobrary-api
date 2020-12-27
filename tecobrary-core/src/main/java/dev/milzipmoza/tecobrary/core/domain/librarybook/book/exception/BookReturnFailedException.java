package dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception;

public class BookReturnFailedException extends BookException {

    public BookReturnFailedException() {
        super();
    }

    public BookReturnFailedException(String message) {
        super(message);
    }

    public BookReturnFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookReturnFailedException(Throwable cause) {
        super(cause);
    }

    protected BookReturnFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
