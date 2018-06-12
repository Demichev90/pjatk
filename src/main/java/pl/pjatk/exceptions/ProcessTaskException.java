package pl.pjatk.exceptions;

/**
 * Created by 169785 on 2018-03-05.
 */
public class ProcessTaskException extends Exception {

    public ProcessTaskException(String message) {
        super(message);

    }

    public ProcessTaskException(Throwable cause) {
        super(cause);

    }

    public ProcessTaskException(String message, Throwable cause) {
        super(message, cause);
    }
}
