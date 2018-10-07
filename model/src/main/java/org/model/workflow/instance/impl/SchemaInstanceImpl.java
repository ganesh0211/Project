package org.model.workflow.instance.impl;

import org.model.workflow.instance.SchemaInstance;
import org.usermanagement.core.model.impl.ObserverCoreImpl;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 4/10/18
 * Time: 11:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "SCHEMAINSTANCE")
public class SchemaInstanceImpl extends ObserverCoreImpl implements SchemaInstance {
    @Override
    public void notifyUpdate() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
