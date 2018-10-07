/**
 * 
 */
package org.model.workflow.enums;

/**
 * @author dugt7420
 *
 */
public enum Status {
	
	UNASSIGNED(0),
	ASSIGNED(1),
	INPROGRESS(2),
	REJECTED(3),
	FAILED(4),
	COMPLETED(5);
	
	
	private int status = -1;
	
	private Status(int status) {
		this.status = status;
	}
	
}
