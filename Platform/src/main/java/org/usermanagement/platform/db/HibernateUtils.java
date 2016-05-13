package org.usermanagement.platform.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 13/5/16
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class HibernateUtils {
    private static Map<String,SessionFactory> sessionFactoryMap = new HashMap<String, SessionFactory>();
    private static SessionFactory sessionFactory;
    private static final String DEFAULT = "DEFAULT";

    public void init(String context){
        if(context == null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
            context = DEFAULT;
        }else{
            sessionFactory = new Configuration().configure(context).buildSessionFactory();
        }
        sessionFactoryMap.put(context,sessionFactory);
    }
    public void init(){
       init(null);
    }

    public Session getSession(String context){
        return sessionFactoryMap.get(context).openSession();
    }
    public Session getSession(){
        return sessionFactoryMap.get(DEFAULT).openSession();
    }

}
