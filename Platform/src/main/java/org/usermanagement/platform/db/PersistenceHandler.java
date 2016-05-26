package org.usermanagement.platform.db;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.usermanagement.platform.util.ApplicationContextProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:35 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class PersistenceHandler {

    @Autowired
    private HibernateUtils hibernateUtils;

    public void setHibernateUtils(HibernateUtils hibernateUtil){
        this.hibernateUtils = hibernateUtil;
    }

    private PersistenceHandler() {

    }

    public Object saveObject(Object obj){
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        obj = session.merge(obj);
        transaction.commit();
        session.close();
        return obj;
    }

    public Object getObjectById(Class entity, long id){
        Session session = null;
        try{
            session = hibernateUtils.getSession();
            Query query = session.createQuery("from " + entity.getName() + " as entity where entity.id =" + id);
            List<Object> objects = query.list();
            if(objects != null && !objects.isEmpty()) {
                return objects.get(0);
            }
        }catch (Exception e) {
            //TO BE HANDLED
            e.printStackTrace();
        }finally {
            if(session != null) {
                session.flush();
                session.close();
            }
        }
        return null;
    }
}
