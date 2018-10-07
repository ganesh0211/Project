package org.model.workflow.template;

import org.usermanagement.core.model.Core;
import org.usermanagement.core.model.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public interface WorkflowProcess extends Core, Observer{
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
     * get Workflow Department
     * @return  WorkflowResourcePool
     */
    public WorkflowResourcePool getWorkflowResourcePool();

    /**
     * set WorkflowResourcePool
     *
     */
    public void setWorkflowResourcePool(WorkflowResourcePool workflowResourcePool);

    /**
     *  getWorkflowSchema
     * @return
     */
    public WorkflowSchema getWorkflowSchema();

    /**
     *  setWorkflowSchema
     * @param workflowSchema
     */
    public void setWorkflowSchema(WorkflowSchema workflowSchema);
}
