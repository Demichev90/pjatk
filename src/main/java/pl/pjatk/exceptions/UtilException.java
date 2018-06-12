package pl.pjatk.exceptions;


public class UtilException extends Exception {

    public UtilException(String message) {
        super(message);

    }

    public UtilException(Throwable cause) {
        super(cause);

    }

    public UtilException(String message, Throwable cause) {
        super(message, cause);
    }
}
