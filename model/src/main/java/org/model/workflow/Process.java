package org.model.workflow;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.usermanagement.core.model.impl.ObserverCoreImpl;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PROCESS")
public class Process extends ObserverCoreImpl {

    @ManyToOne
    private Workflow workflow;

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Process)) return false;
        if (!super.equals(o)) return false;

        Process process = (Process) o;

        if (workflow != null ? !workflow.equals(process.workflow) : process.workflow != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (workflow != null ? workflow.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Process{" +
                "workflow=" + workflow +
                "} " + super.toString();
    }


    @Override
    public void notifyUpdate() {
        // TODO Auto-generated method stub

    }

}
