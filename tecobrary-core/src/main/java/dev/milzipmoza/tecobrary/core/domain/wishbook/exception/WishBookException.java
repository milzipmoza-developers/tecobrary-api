package dev.milzipmoza.tecobrary.core.domain.wishbook.exception;

public class WishBookException extends RuntimeException {

    public WishBookException() {
        super();
    }

    public WishBookException(String message) {
        super(message);
    }

    public WishBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public WishBookException(Throwable cause) {
        super(cause);
    }

    protected WishBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
