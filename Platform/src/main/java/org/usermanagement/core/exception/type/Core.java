package org.usermanagement.core.exception.type;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 9/4/17
 * Time: 12:30 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Core implements Exceptions {

    NO_DATA_FOUND("No data found.", Type.MINOR);

    private final String message;
    private final Type type;

    private Core(final String message, final Type type) {
        this.message = message;
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Core{" +
                "message='" + message + '\'' +
                ", type=" + type +
                "} " + super.toString();
    }
}
