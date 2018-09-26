package org.usermanagement.core.component;

import org.model.usermanagement.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.usermanagement.core.db.PersistenceHandler;
import org.usermanagement.core.exception.ApplicationException;
import org.usermanagement.core.exception.BaseException;
import org.usermanagement.core.exception.BusinessException;
import org.usermanagement.core.exception.type.Core;
import org.usermanagement.core.exception.type.Database;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 12:17 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class RoleManager {
    @Autowired(required=true)
    @Qualifier("DB")
    private PersistenceHandler persistenceHandler;

    public Role saveRole(Role role)
            throws ApplicationException {
        try {
            role = (Role) persistenceHandler.saveObject(null, role);
        } catch (BaseException e) {
            if ((e.getExceptions() instanceof Database)) {
                throw new ApplicationException(Database.SAVE_FAILED);
            }
        }
        return role;
    }

    public Role getRoleById(long id)
            throws ApplicationException, BusinessException {
        Role role = null;
        try {
            role = (Role) persistenceHandler.getObjectById(Role.class, id);
            if (role == null) {
                throw new BusinessException(Core.NO_DATA_FOUND);
            }
        } catch (BaseException e) {
            if ((e.getExceptions() instanceof Database)) {
                throw new ApplicationException(Database.SEARCH_FAILED);
            }
        }
        return role;
    }

    public Role getRoleByName(String name)
            throws ApplicationException, BusinessException {
        List<Role> roles = null;
        try {
            roles = (List<Role>)persistenceHandler.getObjectByProperty(Role.class, "name", name);
            if ((roles == null) || (roles.isEmpty())) {
                throw new BusinessException(Core.NO_DATA_FOUND);
            }
            return (Role) roles.get(0);
        } catch (BaseException e) {
            if ((e.getExceptions() instanceof Database)) {
                throw new ApplicationException(Database.SEARCH_FAILED);
            }
        }
        return null;
    }

    public List<Role> getAllRoles()
            throws ApplicationException, BusinessException {
        List<Role> roles = null;
        try {
            roles = (List<Role>)persistenceHandler.getAllObjects(Role.class);
            if ((roles == null) || (roles.isEmpty())) {
                throw new BusinessException(Core.NO_DATA_FOUND);
            }
        } catch (BaseException e) {
            if ((e.getExceptions() instanceof Database)) {
                throw new ApplicationException(Database.SEARCH_FAILED);
            }
        }
        return roles;
    }
}
