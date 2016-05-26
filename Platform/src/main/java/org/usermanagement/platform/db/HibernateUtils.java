package org.usermanagement.platform.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 13/5/16
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class HibernateUtils {

    @Autowired
    private Map<String,SessionFactory> sessionFactoryMap = new HashMap<String, SessionFactory>();
    private static final String DEFAULT = "mySqlSessionFactory";

    public void setSessionFactory(Map<String,SessionFactory> sessionFactoryMap){
        sessionFactoryMap = sessionFactoryMap;
    }

    public Session getSession(String context){
        return sessionFactoryMap.get(context).openSession();
    }

    public Session getSession(){
        System.out.println(sessionFactoryMap);
        return sessionFactoryMap.get(DEFAULT).openSession();
    }

}
