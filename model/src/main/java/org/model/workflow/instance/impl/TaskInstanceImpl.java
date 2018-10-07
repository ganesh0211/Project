package org.model.workflow.instance.impl;

import org.model.usermanagement.User;
import org.model.workflow.enums.Status;
import org.model.workflow.utils.Sla;
import org.model.workflow.utils.TaskImplementer;
import org.model.workflow.enums.Type;
import org.model.workflow.instance.TaskInstance;
import org.model.workflow.utils.UserTaskInfo;
import org.usermanagement.core.model.impl.ObserverCoreImpl;

import javax.persistence.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 11:55 AM
 * will have only information related to the process or higer level information.
 * Workflow task will have information about the details of task like LLD
 * No single user level workflow task will be created at this moment.
 * Once the task instance is created, user will be assigned to task instance.
 * One task instance will be assigned and created for every user assigned for workflowtask.
 * and group of users with there amount of shares if it is group workflow task.
 */
@Entity
@Table(name = "TASKINSTANCE")
public class TaskInstanceImpl extends ObserverCoreImpl implements TaskInstance {

    private Type type;
    private long execOrder;
    private Status status;
    @Embedded
    private Sla sla;
    private Date plannedStartTime;
    private Date plannedEndTime;
    private Date actualStartTime;
    private Date actualEndTime;

    @Transient
    private TaskImplementer taskImplementer;

    @Embedded
    private UserTaskInfo userTaskInfo;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public long getExecOrder() {
        return execOrder;
    }

    public void setExecOrder(long execOrder) {
        this.execOrder = execOrder;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Sla getSla() {
        return sla;
    }

    public void setSla(Sla sla) {
        this.sla = sla;
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

    public TaskImplementer getTaskImplementer() {
        return taskImplementer;
    }

    public void setTaskImplementer(TaskImplementer taskImplementer) {
        this.taskImplementer = taskImplementer;
    }

    public UserTaskInfo getUserTaskInfo() {
        return userTaskInfo;
    }

    public void setUserTaskInfo(UserTaskInfo userTaskInfo) {
        this.userTaskInfo = userTaskInfo;
    }

    @Override
    public void notifyUpdate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
