package dev.milzipmoza.tecobrary.core.domain.librarybook.exception;

class LibraryBookException extends RuntimeException {

    protected LibraryBookException() {
        super();
    }

    protected LibraryBookException(String message) {
        super(message);
    }

    protected LibraryBookException(String message, Throwable cause) {
        super(message, cause);
    }

    protected LibraryBookException(Throwable cause) {
        super(cause);
    }

    protected LibraryBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
