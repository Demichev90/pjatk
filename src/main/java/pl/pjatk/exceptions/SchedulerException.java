package pl.pjatk.exceptions;

/**
 * Created by 169785 on 2018-03-05.
 */
public class SchedulerException extends Exception {

    public SchedulerException(String message) {
        super(message);

    }

    public SchedulerException(Throwable cause) {
        super(cause);

    }

    public SchedulerException(String message, Throwable cause) {
        super(message, cause);
    }

}

