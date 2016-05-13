package org.usermanagement.platform.db;

import org.usermanagement.platform.util.ApplicationContextProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;


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
    public void saveObject(Object obj){
        ApplicationContextProvider applicationContextProvider = new ApplicationContextProvider();
        System.out.println((applicationContextProvider.getApplicationContext()==null)+" APP NULL");
        HibernateUtils hibernateUtils = new HibernateUtils();//(HibernateUtils)applicationContextProvider.getApplicationContext().getBean("hibernateUtils");
        Session session = hibernateUtils.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }
}
