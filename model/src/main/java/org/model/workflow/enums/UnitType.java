package org.model.workflow.enums;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 7/10/18
 * Time: 10:19 PM
 * To change this template use File | Settings | File Templates.
 */
public enum UnitType {
    RATIO(0),
    PERCENTAGE(1);


    private int type = -1;

    private UnitType(int type) {
        this.type = type;
    }
}
