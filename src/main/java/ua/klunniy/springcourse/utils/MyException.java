package ua.klunniy.springcourse.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * @author Serhii Klunniy
 */
public class MyException extends Exception {
    private static final long serialVersionUID = 5415248000713941020L;

    public MyException(String msg) {
        super(msg);
    }
    public MyException(Throwable t) {
        super(t);
    }
    public MyException() {
        super();
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getError() {
        Throwable rootCause = ExceptionUtils.getRootCause(this);
        if (rootCause != null && rootCause.getMessage() != null) {
            return rootCause.getMessage();
        }
        return getMessage();
    }
}
