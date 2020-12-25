package dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception;

class BookException extends RuntimeException {
    protected BookException() {
        super();
    }

    protected BookException(String message) {
        super(message);
    }

    protected BookException(String message, Throwable cause) {
        super(message, cause);
    }

    protected BookException(Throwable cause) {
        super(cause);
    }

    protected BookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
