package org.usermanagement.platform;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersistenceHandler {
    private static PersistenceHandler ourInstance = new PersistenceHandler();

    public static PersistenceHandler getInstance() {
        return ourInstance;
    }

    private PersistenceHandler() {
    }
}
