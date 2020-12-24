package dev.milzipmoza.tecobrary.core.domain.books.library.exception;

public class LibraryBookUpdateFailedException extends LibraryBookException {

    public LibraryBookUpdateFailedException() {
        super();
    }

    public LibraryBookUpdateFailedException(String message) {
        super(message);
    }

    public LibraryBookUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryBookUpdateFailedException(Throwable cause) {
        super(cause);
    }

    protected LibraryBookUpdateFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
