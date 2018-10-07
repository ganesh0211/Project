package org.model.workflow.template.impl;

import org.model.usermanagement.User;
import org.model.workflow.template.WorkflowProcess;
import org.model.workflow.template.WorkflowTask;
import org.usermanagement.core.model.impl.ObserverCoreImpl;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 *
 * will have only information related to the process or higer level information.
 * Workflow task will have information about the details of task like LLD
 * No single user level workflow task will be created at this moment.
 * Once the task instance is created, user will be assigned to task instance.
 * One task instance will be assigned and created for every user assigned for workflowtask.
 * and group of users with there amount of shares if it is group workflow task.
 *
 */
@Entity
@Table(name = "WORKFLOWTASK")
public class WorkflowTaskImpl extends ObserverCoreImpl
        implements WorkflowTask {

    @ManyToOne(targetEntity = WorkflowProcessImpl.class)
    private WorkflowProcessImpl workflowProcess;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "workflowTask_id",referencedColumnName="id",table = "WORKFLOWTASK"),
            inverseJoinColumns =  @JoinColumn(name = "user_id",referencedColumnName="id",table = "USER"))
    private Set<User> workflowTaskUsers = new HashSet<User>();

    public WorkflowProcess getWorkflowProcess() {
        return workflowProcess;
    }

    public void setWorkflowProcess(WorkflowProcess workflowProcess) {
        this.workflowProcess = (WorkflowProcessImpl)workflowProcess;
    }

    @Override
    public void notifyUpdate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
