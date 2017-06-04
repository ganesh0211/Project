package org.model.workflow;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.model.usermanagement.UserGroup;
import org.springframework.cglib.core.ObjectSwitchCallback;
import org.usermanagement.core.model.impl.ObserverCoreImpl;
import org.usermanagement.core.model.impl.ObserverSimpleImpl;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "WORKFLOWTASK")
public class WorkflowTask extends ObserverCoreImpl {

    private Type type;
    @ManyToOne
    private Workflow workflow;
    private String taskImplementer;
    @ManyToOne
    private UserGroup userGroup;
    @ManyToOne
    private TaskUserGroup taskUserGroup;
    private boolean groupTask;
    private boolean decisionTask;
    @ManyToOne
    private WorkflowTask successTask;
    @ManyToOne
    private WorkflowTask failureTask;
    @ManyToOne
    private WorkflowTask previousTask;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    public String getTaskImplementer() {
        return taskImplementer;
    }

    public void setTaskImplementer(String taskImplementer) {
        this.taskImplementer = taskImplementer;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public TaskUserGroup getTaskUserGroup() {
        return taskUserGroup;
    }

    public void setTaskUserGroup(TaskUserGroup taskUserGroup) {
        this.taskUserGroup = taskUserGroup;
    }

    public boolean isGroupTask() {
        return groupTask;
    }

    public void setGroupTask(boolean groupTask) {
        this.groupTask = groupTask;
    }

    public boolean isDecisionTask() {
        return decisionTask;
    }

    public void setDecisionTask(boolean decisionTask) {
        this.decisionTask = decisionTask;
    }

    public WorkflowTask getSuccessTask() {
        return successTask;
    }

    public void setSuccessTask(WorkflowTask successTask) {
        this.successTask = successTask;
    }

    public WorkflowTask getFailureTask() {
        return failureTask;
    }

    public void setFailureTask(WorkflowTask failureTask) {
        this.failureTask = failureTask;
    }

    public WorkflowTask getPreviousTask() {
        return previousTask;
    }

    public void setPreviousTask(WorkflowTask previousTask) {
        this.previousTask = previousTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkflowTask)) return false;

        WorkflowTask that = (WorkflowTask) o;

        if (decisionTask != that.decisionTask) return false;
        if (groupTask != that.groupTask) return false;
        if (failureTask != null ? !failureTask.equals(that.failureTask) : that.failureTask != null) return false;
        if (previousTask != null ? !previousTask.equals(that.previousTask) : that.previousTask != null) return false;
        if (successTask != null ? !successTask.equals(that.successTask) : that.successTask != null) return false;
        if (taskImplementer != null ? !taskImplementer.equals(that.taskImplementer) : that.taskImplementer != null)
            return false;
        if (taskUserGroup != null ? !taskUserGroup.equals(that.taskUserGroup) : that.taskUserGroup != null)
            return false;
        if (type != that.type) return false;
        if (userGroup != null ? !userGroup.equals(that.userGroup) : that.userGroup != null) return false;
        if (workflow != null ? !workflow.equals(that.workflow) : that.workflow != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + (workflow != null ? workflow.hashCode() : 0);
        result = 31 * result + (taskImplementer != null ? taskImplementer.hashCode() : 0);
        result = 31 * result + (userGroup != null ? userGroup.hashCode() : 0);
        result = 31 * result + (taskUserGroup != null ? taskUserGroup.hashCode() : 0);
        result = 31 * result + (groupTask ? 1 : 0);
        result = 31 * result + (decisionTask ? 1 : 0);
        result = 31 * result + (successTask != null ? successTask.hashCode() : 0);
        result = 31 * result + (failureTask != null ? failureTask.hashCode() : 0);
        result = 31 * result + (previousTask != null ? previousTask.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkflowTask{" +
                "type=" + type +
                ", workflow=" + workflow +
                ", taskImplementer='" + taskImplementer + '\'' +
                ", userGroup=" + userGroup +
                ", taskUserGroup=" + taskUserGroup +
                ", groupTask=" + groupTask +
                ", decisionTask=" + decisionTask +
                ", successTask=" + successTask +
                ", failureTask=" + failureTask +
                ", previousTask=" + previousTask +
                "} " + super.toString();
    }


    @Override
    public void notifyUpdate() {
        // TODO Auto-generated method stub exampleof result
    }

}
