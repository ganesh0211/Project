package org.workflow.core;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 3/10/18
 * Time: 4:20 PM
 * To change this template use File | Settings | File Templates.
 */
public interface WorkflowPlanner {
    /**
     * Plan a workflow process
     */
    public void plan();

    /**
     *  Plan a workflow process at date
     * @param date
     */
    public void planAt(Date date);

    /**
     * Cancel plan for workflow process
     */
    public void cancelPlan();

    /**
     *
     * @param date
     */
    public void reschedulePlanAt(Date date);
}
