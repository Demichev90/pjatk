package pl.pjatk.exceptions;

/**
 * Created by 169785 on 2018-03-07.
 */
public class VariableException extends Exception {

    public VariableException(String message) {
        super(message);

    }

    public VariableException(Throwable cause) {
        super(cause);

    }

    public VariableException(String message, Throwable cause) {
        super(message, cause);
    }
}
