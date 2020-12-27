package dev.milzipmoza.tecobrary.core.domain.librarybook.book.exception;

public class BookRentMemberIdentifyFailedException extends BookException {

    public BookRentMemberIdentifyFailedException() {
        super();
    }

    public BookRentMemberIdentifyFailedException(String message) {
        super(message);
    }

    public BookRentMemberIdentifyFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookRentMemberIdentifyFailedException(Throwable cause) {
        super(cause);
    }

    protected BookRentMemberIdentifyFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
