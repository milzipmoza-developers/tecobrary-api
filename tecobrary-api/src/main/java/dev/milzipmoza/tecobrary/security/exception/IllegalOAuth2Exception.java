package dev.milzipmoza.tecobrary.security.exception;

public class IllegalOAuth2Exception extends RuntimeException {

    public IllegalOAuth2Exception() {
        super();
    }

    public IllegalOAuth2Exception(String message) {
        super(message);
    }

    public IllegalOAuth2Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalOAuth2Exception(Throwable cause) {
        super(cause);
    }

    protected IllegalOAuth2Exception(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
