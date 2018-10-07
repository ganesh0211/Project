package org.model.workflow.template;


import org.usermanagement.core.model.Core;
import org.usermanagement.core.model.Observer;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public interface WorkflowTask extends Core, Observer {
    /**
     *
     * @return
     */
    public WorkflowProcess getWorkflowProcess();

    /**
     *
     * @param workflowProcess
     */
    public void setWorkflowProcess(WorkflowProcess workflowProcess);
}
