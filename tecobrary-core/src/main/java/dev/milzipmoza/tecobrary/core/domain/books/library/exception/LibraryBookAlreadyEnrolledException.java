package dev.milzipmoza.tecobrary.core.domain.books.library.exception;

public class LibraryBookAlreadyEnrolledException extends LibraryBookException {

    public LibraryBookAlreadyEnrolledException() {
        super();
    }

    public LibraryBookAlreadyEnrolledException(String message) {
        super(message);
    }

    public LibraryBookAlreadyEnrolledException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryBookAlreadyEnrolledException(Throwable cause) {
        super(cause);
    }
}
