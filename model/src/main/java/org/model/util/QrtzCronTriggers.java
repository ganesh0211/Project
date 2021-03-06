package org.model.util;
// Generated 2 Oct, 2018 11:19:34 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * QrtzCronTriggers generated by hbm2java
 */
@Entity
@Table(name="qrtz_cron_triggers"
    ,catalog="USERMANAGER"
)
public class QrtzCronTriggers  implements java.io.Serializable {


     private QrtzCronTriggersId id;
     private String cronExpression;
     private String timeZoneId;

    public QrtzCronTriggers() {
    }

	
    public QrtzCronTriggers(QrtzCronTriggersId id, String cronExpression) {
        this.id = id;
        this.cronExpression = cronExpression;
    }
    public QrtzCronTriggers(QrtzCronTriggersId id, String cronExpression, String timeZoneId) {
       this.id = id;
       this.cronExpression = cronExpression;
       this.timeZoneId = timeZoneId;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="schedName", column=@Column(name="SCHED_NAME", nullable=false, length=120) ), 
        @AttributeOverride(name="triggerName", column=@Column(name="TRIGGER_NAME", nullable=false, length=200) ), 
        @AttributeOverride(name="triggerGroup", column=@Column(name="TRIGGER_GROUP", nullable=false, length=200) ) } )
    public QrtzCronTriggersId getId() {
        return this.id;
    }
    
    public void setId(QrtzCronTriggersId id) {
        this.id = id;
    }
    
    @Column(name="CRON_EXPRESSION", nullable=false, length=200)
    public String getCronExpression() {
        return this.cronExpression;
    }
    
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
    
    @Column(name="TIME_ZONE_ID", length=80)
    public String getTimeZoneId() {
        return this.timeZoneId;
    }
    
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }




}


