package org.usermanagement.core.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.usermanagement.model.User;
import org.usermanagement.platform.db.PersistenceHandler;
import org.usermanagement.platform.db.PersistenceHandlerImpl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 26/5/16
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class UserManager {

    @Autowired
    private PersistenceHandler persistenceHandler;

    public User saveUserManager(User user){
        return (User) persistenceHandler.saveObject(user);

    }

    public User getUserById(long id) {
        return (User) persistenceHandler.getObjectById(User.class,id);
    }

    public List<User> getUserByUserName(String username) {
        return (List<User>) persistenceHandler.getObjectByProperty(User.class,"username","ROOT");
    }
}
