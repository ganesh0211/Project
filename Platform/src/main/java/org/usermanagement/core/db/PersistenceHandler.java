package org.usermanagement.core.db;

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
     * @param context
     * @param obj
     * @return
     * @throws BaseException
     */
    public Object saveObject(String context, Object obj) throws BaseException;

    /**
     * @param context
     * @param object
     * @return
     * @throws BaseException
     */
    public Object deleteObject(String context, Object object) throws BaseException;

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

    /**
     *
     * @param entity
     * @return
     * @throws BaseException
     */
    public List<?> getAllObjects(Class entity) throws BaseException;

    /**
     *
     * @param entity
     * @param condition
     * @return
     * @throws BaseException
     */
    public List<?> getAllObjectsByCondition(Class entity, String condition) throws BaseException;
}
