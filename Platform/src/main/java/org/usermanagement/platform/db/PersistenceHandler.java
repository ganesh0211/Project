package org.usermanagement.platform.db;

import org.usermanagement.core.exception.BaseException;

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
     * @param object
     * @return
     */
    public Object saveObject(Object object) throws BaseException;

    /**
     * @param object
     * @return
     * @throws BaseException
     */
    public Object deleteObject(Object object) throws BaseException;

    /**
     * @param entity
     * @param id
     * @return
     */
    public Object getObjectById(Class entity, long id) throws BaseException;

    /**
     * @param entity
     * @param property
     * @param value
     * @return
     */
    public List<?> getObjectByProperty(Class entity, String property, String value) throws BaseException;
}
