package org.model.workflow.utils;

import org.model.usermanagement.User;
import org.model.workflow.enums.UnitType;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 7/10/18
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class UserTaskInfo implements Serializable {
    /**
     *
     */
    @ManyToOne
    private User user;
    /**
     *
     */
    private long unit;
    /**
     *
     */
    private UnitType unitType;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getUnit() {
        return unit;
    }

    public void setUnit(long unit) {
        this.unit = unit;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }
}
