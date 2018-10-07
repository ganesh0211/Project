package org.model.workflow.template.impl;

import org.model.usermanagement.User;
import org.model.workflow.template.WorkflowResourcePool;
import org.usermanagement.core.model.impl.ObserverCoreImpl;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "WORKFLOWRESOURCEPOOL")
public class WorkflowResourcePoolImpl extends ObserverCoreImpl
        implements WorkflowResourcePool {

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "workflowResourcePool_id",referencedColumnName="id",table = "WORKFLOWRESOURCEPOOL"),
            inverseJoinColumns =  @JoinColumn(name = "user_id",referencedColumnName="id",table = "USER"))
    private Set<User> users = new HashSet<User>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public void notifyUpdate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
