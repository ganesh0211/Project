package org.model.workflow;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.model.usermanagement.UserGroup;
import org.usermanagement.core.model.impl.ObserverSimpleImpl;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "WORKFLOWTASK")
public class WorkflowTask extends ObserverSimpleImpl {
	
	private Type type;
	private Workflow workflow;
	private String taskImplementer;
	private UserGroup userGroup;
	private TaskUserGroup taskUserGroup;
	private boolean groupTask;
	private boolean decisionTask;
	private WorkflowTask successTask;
	private WorkflowTask failureTask;
	private WorkflowTask previousTask;

	
	@Override
	public void notifyUpdate() {
		// TODO Auto-generated method stub exampleof result
	}

}
