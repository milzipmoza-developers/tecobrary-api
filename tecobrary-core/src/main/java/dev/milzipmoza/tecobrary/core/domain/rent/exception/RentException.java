package dev.milzipmoza.tecobrary.core.domain.rent.exception;

public class RentException extends RuntimeException {

    protected RentException() {
        super();
    }

    protected RentException(String message) {
        super(message);
    }

    protected RentException(String message, Throwable cause) {
        super(message, cause);
    }

    protected RentException(Throwable cause) {
        super(cause);
    }

    protected RentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
