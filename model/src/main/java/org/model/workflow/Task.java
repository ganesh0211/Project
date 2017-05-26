package org.model.workflow;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.usermanagement.core.model.impl.ObserverSimpleImpl;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "TASK")
public class Task extends ObserverSimpleImpl {
	
	private Status status;
	private Type type;
	private Process process;
	private TaskImplementer taskImplementer;
	private TaskUserGroup taskUserGroup;
	private boolean groupTask;
	private Date plannedStartTime;
	private Date plannedEndTime;
	private Date actualStartTime;
	private Date actualEndTime;
	private Task successTask;
	private Task failureTask;
	private Task previousTask;
	
	@Override
	public void notifyUpdate() {
		// TODO Auto-generated method stub
		Result result = taskImplementer.execute();
		Boolean returnValue = (Boolean) result.returnType.cast(result.returnValue);
	}

}
