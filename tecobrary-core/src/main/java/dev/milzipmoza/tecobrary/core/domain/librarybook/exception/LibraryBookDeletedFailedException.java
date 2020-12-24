package dev.milzipmoza.tecobrary.core.domain.librarybook.exception;

public class LibraryBookDeletedFailedException extends LibraryBookException {

    public LibraryBookDeletedFailedException() {
        super();
    }

    public LibraryBookDeletedFailedException(String message) {
        super(message);
    }

    public LibraryBookDeletedFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryBookDeletedFailedException(Throwable cause) {
        super(cause);
    }

    protected LibraryBookDeletedFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
