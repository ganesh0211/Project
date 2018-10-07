package org.model.workflow.instance;

import org.model.usermanagement.User;
import org.model.workflow.enums.Status;
import org.model.workflow.enums.Type;
import org.model.workflow.utils.Sla;
import org.model.workflow.utils.TaskImplementer;
import org.model.workflow.utils.UserTaskInfo;
import org.usermanagement.core.model.Core;
import org.usermanagement.core.model.Observer;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 11:55 AM
 * To change this template use File | Settings | File Templates.
 */
public interface TaskInstance extends Core, Observer {
    /**
     *
     * @return
     */
    public Type getType();

    /**
     *
     * @param type
     */
    public void setType(Type type);

    /**
     *
     * @return
     */
    public long getExecOrder() ;

    /**
     *
     * @param order
     */
    public void setExecOrder(long execOrder) ;

    /**
     *
     * @return
     */
    public Status getStatus();

    /**
     *
     * @param status
     */
    public void setStatus(Status status);

    /**
     *
     * @return
     */
    public Sla getSla() ;

    /**
     *
     * @param sla
     */
    public void setSla(Sla sla);
    /**
     *
     * @return
     */
    public Date getPlannedStartTime();

    /**
     *
     * @param plannedStartTime
     */
    public void setPlannedStartTime(Date plannedStartTime);

    /**
     *
     * @return
     */
    public Date getPlannedEndTime();

    /**
     *
     * @param plannedEndTime
     */
    public void setPlannedEndTime(Date plannedEndTime);

    /**
     *
     * @return
     */
    public Date getActualStartTime();

    /**
     *
     * @param actualStartTime
     */
    public void setActualStartTime(Date actualStartTime);

    /**
     *
     * @return
     */
    public Date getActualEndTime();

    /**
     *
     * @param actualEndTime
     */
    public void setActualEndTime(Date actualEndTime);

    /**
     *
     * @return
     */
    public TaskImplementer getTaskImplementer();

    /**
     *
     * @param taskImplementer
     */
    public void setTaskImplementer(TaskImplementer taskImplementer);

    /**
     *
     * @return
     */
    public UserTaskInfo getUserTaskInfo();

    /**
     *
     * @param userTaskInfo
     */
    public void setUserTaskInfo(UserTaskInfo userTaskInfo);
}
