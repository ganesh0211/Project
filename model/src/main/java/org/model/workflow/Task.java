package org.model.workflow;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "TASK")
public class Task extends ObserverCoreImpl {
    private Status status;
    private Type type;
    @ManyToOne
    private Process process;
    private TaskImplementer taskImplementer;
    @ManyToOne
    private TaskUserGroup taskUserGroup;
    private boolean groupTask;
    private Date plannedStartTime;
    private Date plannedEndTime;
    private Date actualStartTime;
    private Date actualEndTime;
    @ManyToOne
    private Task successTask;
    @ManyToOne
    private Task failureTask;
    @ManyToOne
    private Task previousTask;


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public TaskImplementer getTaskImplementer() {
        return taskImplementer;
    }

    public void setTaskImplementer(TaskImplementer taskImplementer) {
        this.taskImplementer = taskImplementer;
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

    public Date getPlannedStartTime() {
        return plannedStartTime;
    }

    public void setPlannedStartTime(Date plannedStartTime) {
        this.plannedStartTime = plannedStartTime;
    }

    public Date getPlannedEndTime() {
        return plannedEndTime;
    }

    public void setPlannedEndTime(Date plannedEndTime) {
        this.plannedEndTime = plannedEndTime;
    }

    public Date getActualStartTime() {
        return actualStartTime;
    }

    public void setActualStartTime(Date actualStartTime) {
        this.actualStartTime = actualStartTime;
    }

    public Date getActualEndTime() {
        return actualEndTime;
    }

    public void setActualEndTime(Date actualEndTime) {
        this.actualEndTime = actualEndTime;
    }

    public Task getSuccessTask() {
        return successTask;
    }

    public void setSuccessTask(Task successTask) {
        this.successTask = successTask;
    }

    public Task getFailureTask() {
        return failureTask;
    }

    public void setFailureTask(Task failureTask) {
        this.failureTask = failureTask;
    }

    public Task getPreviousTask() {
        return previousTask;
    }

    public void setPreviousTask(Task previousTask) {
        this.previousTask = previousTask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (groupTask != task.groupTask) return false;
        if (actualEndTime != null ? !actualEndTime.equals(task.actualEndTime) : task.actualEndTime != null)
            return false;
        if (actualStartTime != null ? !actualStartTime.equals(task.actualStartTime) : task.actualStartTime != null)
            return false;
        if (failureTask != null ? !failureTask.equals(task.failureTask) : task.failureTask != null) return false;
        if (plannedEndTime != null ? !plannedEndTime.equals(task.plannedEndTime) : task.plannedEndTime != null)
            return false;
        if (plannedStartTime != null ? !plannedStartTime.equals(task.plannedStartTime) : task.plannedStartTime != null)
            return false;
        if (previousTask != null ? !previousTask.equals(task.previousTask) : task.previousTask != null) return false;
        if (process != null ? !process.equals(task.process) : task.process != null) return false;
        if (status != task.status) return false;
        if (successTask != null ? !successTask.equals(task.successTask) : task.successTask != null) return false;
        if (taskImplementer != null ? !taskImplementer.equals(task.taskImplementer) : task.taskImplementer != null)
            return false;
        if (taskUserGroup != null ? !taskUserGroup.equals(task.taskUserGroup) : task.taskUserGroup != null)
            return false;
        if (type != task.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + (process != null ? process.hashCode() : 0);
        result = 31 * result + (taskImplementer != null ? taskImplementer.hashCode() : 0);
        result = 31 * result + (taskUserGroup != null ? taskUserGroup.hashCode() : 0);
        result = 31 * result + (groupTask ? 1 : 0);
        result = 31 * result + (plannedStartTime != null ? plannedStartTime.hashCode() : 0);
        result = 31 * result + (plannedEndTime != null ? plannedEndTime.hashCode() : 0);
        result = 31 * result + (actualStartTime != null ? actualStartTime.hashCode() : 0);
        result = 31 * result + (actualEndTime != null ? actualEndTime.hashCode() : 0);
        result = 31 * result + (successTask != null ? successTask.hashCode() : 0);
        result = 31 * result + (failureTask != null ? failureTask.hashCode() : 0);
        result = 31 * result + (previousTask != null ? previousTask.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "status=" + status +
                ", type=" + type +
                ", process=" + process +
                ", taskImplementer=" + taskImplementer +
                ", taskUserGroup=" + taskUserGroup +
                ", groupTask=" + groupTask +
                ", plannedStartTime=" + plannedStartTime +
                ", plannedEndTime=" + plannedEndTime +
                ", actualStartTime=" + actualStartTime +
                ", actualEndTime=" + actualEndTime +
                ", successTask=" + successTask +
                ", failureTask=" + failureTask +
                ", previousTask=" + previousTask +
                "} " + super.toString();
    }


    @Override
    public void notifyUpdate() {
        // TODO Auto-generated method stub
        Result result = taskImplementer.execute();
        Boolean returnValue = (Boolean) result.returnType.cast(result.returnValue);
    }

}
