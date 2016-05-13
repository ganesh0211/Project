package org.usermanagement.platform.util;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;
/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 13/5/16
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationContextProvider implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }
    public ApplicationContext getApplicationContext(){
        return this.applicationContext;
    }
}
