package org.usermanagement.core.db;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("sessionFactoryMap")
    private Map<String, SessionFactory> sessionFactoryMap = new HashMap<String, SessionFactory>();
    public static final String DEFAULT = "mySqlSessionFactory";

    public void setSessionFactory(Map<String, SessionFactory> sessionFactoryMap) {
        this.sessionFactoryMap = sessionFactoryMap;
    }

    public Session getSession(String context) {
        return sessionFactoryMap.get(context).openSession();
    }

    public Session getSession() {
        return getSession(DEFAULT);
    }

}
