package fr.nirahtech.limayrac.ecommerce;

public class MissingApiTokenException extends RuntimeException {

    /**
     * 
     */
    public MissingApiTokenException() {
    }

    /**
     * @param message
     */
    public MissingApiTokenException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public MissingApiTokenException(Throwable cause) {
        super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public MissingApiTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public MissingApiTokenException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
