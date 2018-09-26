package org.model.scheduler;
// Generated 26 Sep, 2018 8:49:36 PM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QrtzTriggersId generated by hbm2java
 */
@Embeddable
public class QrtzTriggersId  implements java.io.Serializable {


     private String schedName;
     private String triggerName;
     private String triggerGroup;

    public QrtzTriggersId() {
    }

    public QrtzTriggersId(String schedName, String triggerName, String triggerGroup) {
       this.schedName = schedName;
       this.triggerName = triggerName;
       this.triggerGroup = triggerGroup;
    }
   

    @Column(name="SCHED_NAME", nullable=false, length=120)
    public String getSchedName() {
        return this.schedName;
    }
    
    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Column(name="TRIGGER_NAME", nullable=false, length=200)
    public String getTriggerName() {
        return this.triggerName;
    }
    
    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    @Column(name="TRIGGER_GROUP", nullable=false, length=200)
    public String getTriggerGroup() {
        return this.triggerGroup;
    }
    
    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof QrtzTriggersId) ) return false;
		 QrtzTriggersId castOther = ( QrtzTriggersId ) other; 
         
		 return ( (this.getSchedName()==castOther.getSchedName()) || ( this.getSchedName()!=null && castOther.getSchedName()!=null && this.getSchedName().equals(castOther.getSchedName()) ) )
 && ( (this.getTriggerName()==castOther.getTriggerName()) || ( this.getTriggerName()!=null && castOther.getTriggerName()!=null && this.getTriggerName().equals(castOther.getTriggerName()) ) )
 && ( (this.getTriggerGroup()==castOther.getTriggerGroup()) || ( this.getTriggerGroup()!=null && castOther.getTriggerGroup()!=null && this.getTriggerGroup().equals(castOther.getTriggerGroup()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSchedName() == null ? 0 : this.getSchedName().hashCode() );
         result = 37 * result + ( getTriggerName() == null ? 0 : this.getTriggerName().hashCode() );
         result = 37 * result + ( getTriggerGroup() == null ? 0 : this.getTriggerGroup().hashCode() );
         return result;
   }   


}


