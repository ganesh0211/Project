package org.model.workflow.template.impl;

import org.model.workflow.template.WorkflowSchema;
import org.usermanagement.core.model.impl.ObserverCoreImpl;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "WORKFLOWSCHEMA")
public class WorkflowSchemaImpl extends ObserverCoreImpl implements WorkflowSchema {

    @Override
    public void notifyUpdate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
