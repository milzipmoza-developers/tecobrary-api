package dev.milzipmoza.tecobrary.core.domain.rent.exception;

public class RentNotFoundException extends RentException {

    public RentNotFoundException() {
        super();
    }

    public RentNotFoundException(String message) {
        super(message);
    }

    public RentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RentNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
