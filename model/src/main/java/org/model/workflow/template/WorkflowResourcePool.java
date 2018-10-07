package org.model.workflow.template;

import org.model.usermanagement.User;
import org.usermanagement.core.model.Core;
import org.usermanagement.core.model.Observer;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface WorkflowResourcePool extends Core, Observer {
    /**
     *
     * @return
     */
    public Set<User> getUsers();

    /**
     *
     * @param users
     */
    public void setUsers(Set<User> users);

}
