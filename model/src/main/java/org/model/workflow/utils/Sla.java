package org.model.workflow.utils;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 7/10/18
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Embeddable
public class Sla implements Serializable {
    /**
     *
     */
    private long unitTime;
    /**
     *

     */
    private TimeUnit timeUnit;

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public long getUnitTime() {
        return unitTime;
    }

    public void setUnitTime(long unitTime) {
        this.unitTime = unitTime;
    }





}
