package org.usermanagement.core.exception;

import org.usermanagement.core.exception.type.Exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 9/4/17
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationException extends BaseException {

    public ApplicationException(Exceptions exceptions) {
        super(exceptions);
    }
}
