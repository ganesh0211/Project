package org.usermanagement.core.exception.type;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 9/4/17
 * Time: 12:31 AM
 * To change this template use File | Settings | File Templates.
 */
public enum Database implements Exceptions {
    SAVE_FAILED("Saving the object failed", Type.CRITICAL),
    DELETE_FAILED("Deletion of object failed", Type.CRITICAL),
    SEARCH_FAILED("Search failed", Type.MINOR);

    private final String message;
    private final Type type;

    private Database(final String message, final Type type) {
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
        return "Database{" +
                "message='" + message + '\'' +
                ", type=" + type +
                "} " + super.toString();
    }
}
