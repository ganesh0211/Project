package org.usermanagement.core.exception;

import org.usermanagement.core.exception.type.Exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 9/4/17
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class BaseException extends Exception {
    /**
     * Exception
     */
    private Exceptions exceptions;

    public BaseException(final Exceptions exceptions) {
        this.exceptions = exceptions;
    }

    public Exceptions getExceptions() {
        return exceptions;
    }
}
