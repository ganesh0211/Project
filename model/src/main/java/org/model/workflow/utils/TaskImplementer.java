/**
 * 
 */
package org.model.workflow.utils;

import org.model.workflow.utils.Result;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 11/5/16
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TaskImplementer {
	
	/**
	 * 
	 */
	public void init();
	
	/**
	 * 
	 */
	public Result execute(Object data);
	
	/**
	 * 
	 */
	public void destroy();
}
