package org.usermanagement.platform.db;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 27/5/16
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PersistenceHandler {

    /**
     *
     * @param object
     * @return
     */
    public Object saveObject(Object object);

    /**
     *
     * @param entity
     * @param id
     * @return
     */
    public Object getObjectById(Class entity, long id);

    /**
     *
     * @param entity
     * @param property
     * @param value
     * @return
     */
    public List<?> getObjectByProperty(Class entity, String property, String value);
}
