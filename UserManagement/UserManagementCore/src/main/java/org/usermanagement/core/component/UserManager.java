package org.usermanagement.core.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.usermanagement.core.exception.ApplicationException;
import org.usermanagement.core.exception.BaseException;
import org.usermanagement.core.exception.BusinessException;
import org.usermanagement.core.exception.type.Core;
import org.usermanagement.core.exception.type.Database;
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

    public User saveUserManager(User user) throws ApplicationException {
        try {
            user = (User) persistenceHandler.saveObject(user);
        } catch (BaseException e) {
            if (e.getExceptions() instanceof Database) {
                throw new ApplicationException(Database.SAVE_FAILED);
            }
        }
        return user;

    }

    public User getUserById(long id) throws ApplicationException, BusinessException {
        User user = null;
        try {
            user = (User) persistenceHandler.getObjectById(User.class, id);
            if (user == null) {
                throw new BusinessException(Core.NO_DATA_FOUND);
            }
        } catch (BaseException e) {
            if (e.getExceptions() instanceof Database) {
                throw new ApplicationException(Database.SEARCH_FAILED);
            }
        }
        return user;
    }

    public List<User> getUserByUserName(String username) throws ApplicationException, BusinessException {
        List<User> users = null;
        try {
            users = (List<User>) persistenceHandler.getObjectByProperty(User.class, "username", "ROOT");
            if (users == null) {
                throw new BusinessException(Core.NO_DATA_FOUND);
            }
        } catch (BaseException e) {
            if (e.getExceptions() instanceof Database) {
                throw new ApplicationException(Database.SEARCH_FAILED);
            }
        }
        return users;
    }
}
