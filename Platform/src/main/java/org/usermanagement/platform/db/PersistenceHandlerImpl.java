package org.usermanagement.platform.db;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.usermanagement.core.exception.BaseException;
import org.usermanagement.core.exception.type.Database;
import org.usermanagement.core.exception.type.Exceptions;
import org.usermanagement.core.model.Core;
import org.usermanagement.core.model.Observer;
import org.usermanagement.core.util.DateUtil;
import org.usermanagement.core.util.impl.DateUtilImpl;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PersistenceHandlerImpl implements PersistenceHandler {

    @Autowired
    private HibernateUtils hibernateUtils;
    private DateUtil dateUtil = new DateUtilImpl();

    private PersistenceHandlerImpl() {

    }

    public Object saveObject(Object obj) throws BaseException {
        Session session = null;
        try {
            session = hibernateUtils.getSession();
            Transaction transaction = session.beginTransaction();
            preSaveUpdate(obj);
            obj = session.merge(obj);
            session.flush();
            transaction.commit();
            postSaveUpdate(obj);
        } catch (Exception e) {
            throw new BaseException(Database.SAVE_FAILED);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return obj;
    }

    private void preSaveUpdate(Object object) {
        if (object instanceof Core) {
            if (((Core) object).getCreationDate() == null) {
                ((Core) object).setCreationDate(dateUtil.getCurrentUTCDate());

            }
            ((Core) object).setEnabled(true);
            ((Core) object).setModifiedDate(dateUtil.getCurrentUTCDate());
            ((Core) object).updateVersion();
        }
    }

    private void postSaveUpdate(Object object) {
        if (object instanceof Observer) {
            ((Observer) object).notifyUpdate();
        }
    }


    @Override
    public Object deleteObject(Object object) throws BaseException {
        Session session = null;
        try {
            session = hibernateUtils.getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(object);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            throw new BaseException(Database.DELETE_FAILED);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return object;
    }

    public Object getObjectById(Class entity, long id) throws BaseException {
        Session session = null;
        try {
            session = hibernateUtils.getSession();
            Query query = session.createQuery("from " + entity.getName() + " as entity where entity.id =" + id);
            List<Object> objects = query.list();
            if (objects != null && !objects.isEmpty()) {
                return objects.get(0);
            }
        } catch (Exception e) {
            throw new BaseException(Database.SEARCH_FAILED);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return null;
    }

    public List<?> getObjectByProperty(Class entity, String property, String value) throws BaseException {
        Session session = null;
        try {
            session = hibernateUtils.getSession();
            Query query = session.createQuery("from " + entity.getName() + " as entity where entity." + property + " = '" + value + "'");
            return query.list();
        } catch (Exception e) {
            throw new BaseException(Database.SEARCH_FAILED);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
}
