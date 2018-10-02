package org.model.util;
// Generated 2 Oct, 2018 11:19:34 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * QrtzCalendars generated by hbm2java
 */
@Entity
@Table(name="qrtz_calendars"
    ,catalog="USERMANAGER"
)
public class QrtzCalendars  implements java.io.Serializable {


     private QrtzCalendarsId id;
     private byte[] calendar;

    public QrtzCalendars() {
    }

    public QrtzCalendars(QrtzCalendarsId id, byte[] calendar) {
       this.id = id;
       this.calendar = calendar;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="schedName", column=@Column(name="SCHED_NAME", nullable=false, length=120) ), 
        @AttributeOverride(name="calendarName", column=@Column(name="CALENDAR_NAME", nullable=false, length=200) ) } )
    public QrtzCalendarsId getId() {
        return this.id;
    }
    
    public void setId(QrtzCalendarsId id) {
        this.id = id;
    }
    
    @Column(name="CALENDAR", nullable=false)
    public byte[] getCalendar() {
        return this.calendar;
    }
    
    public void setCalendar(byte[] calendar) {
        this.calendar = calendar;
    }




}


