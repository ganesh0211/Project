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
	
	@Override
	public void notifyUpdate() {
		// TODO Auto-generated method stub

	}

}
