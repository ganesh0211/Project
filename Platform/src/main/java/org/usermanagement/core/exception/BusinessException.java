package org.usermanagement.core.exception;

import org.usermanagement.core.exception.type.Exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 9/4/17
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class BusinessException extends BaseException {

    public BusinessException(Exceptions exceptions) {
        super(exceptions);
    }
}
