/**
 * 
 */
package org.model.workflow.enums;

/**
 * @author dugt7420
 *
 */
public enum Type {
	AUTOMATIC(0),
	MANUAL(1);
	
	private int type = -1;
	
	private Type(int type) {
		this.type = type;
	}
	
}
