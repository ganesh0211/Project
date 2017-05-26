package org.model.usermanagement;


import org.usermanagement.core.model.impl.ObserverCoreImpl;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "USERGROUP")
public class UserGroup extends ObserverCoreImpl {

	
	@Override
	public void notifyUpdate() {
		// TODO Auto-generated method stub
		
	}

   
}
