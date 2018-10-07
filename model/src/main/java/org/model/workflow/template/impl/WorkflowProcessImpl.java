package org.model.workflow.template.impl;

import org.model.workflow.template.WorkflowResourcePool;
import org.model.workflow.template.WorkflowProcess;
import org.model.workflow.template.WorkflowSchema;
import org.usermanagement.core.model.impl.ObserverCoreImpl;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "WORKFLOWPROCESS")
public class WorkflowProcessImpl extends ObserverCoreImpl
        implements WorkflowProcess {

    private long execOrder;

    @ManyToOne(targetEntity = WorkflowResourcePoolImpl.class)
    private WorkflowResourcePoolImpl workflowResourcePool;

    @ManyToOne(targetEntity = WorkflowSchemaImpl.class)
    private WorkflowSchemaImpl workflowSchema;

    public long getExecOrder() {
        return execOrder;
    }

    public void setExecOrder(long execOrder) {
        this.execOrder = execOrder;
    }

    public WorkflowResourcePool getWorkflowResourcePool() {
        return workflowResourcePool;
    }

    public void setWorkflowResourcePool(WorkflowResourcePool workflowResourcePool) {
        this.workflowResourcePool = (WorkflowResourcePoolImpl) workflowResourcePool;
    }

    public WorkflowSchema getWorkflowSchema() {
        return workflowSchema;
    }

    public void setWorkflowSchema(WorkflowSchema workflowSchema) {
        this.workflowSchema = (WorkflowSchemaImpl)workflowSchema;
    }

    @Override
    public void notifyUpdate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
