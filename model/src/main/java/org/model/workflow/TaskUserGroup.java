package org.model.workflow;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.model.usermanagement.User;
import org.usermanagement.core.model.impl.ObserverCoreImpl;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "TASKUSERGROUP")
public class TaskUserGroup extends ObserverCoreImpl {
    //private List<User> users;


    @Override
    public void notifyUpdate() {
        // TODO Auto-generated method stub

    }
}
