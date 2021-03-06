package org.model.util;
// Generated 2 Oct, 2018 11:19:34 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QrtzPausedTriggerGrpsId generated by hbm2java
 */
@Embeddable
public class QrtzPausedTriggerGrpsId  implements java.io.Serializable {


     private String schedName;
     private String triggerGroup;

    public QrtzPausedTriggerGrpsId() {
    }

    public QrtzPausedTriggerGrpsId(String schedName, String triggerGroup) {
       this.schedName = schedName;
       this.triggerGroup = triggerGroup;
    }
   

    @Column(name="SCHED_NAME", nullable=false, length=120)
    public String getSchedName() {
        return this.schedName;
    }
    
    public void setSchedName(String schedName) {
        this.schedName = schedName;
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
		 if ( !(other instanceof QrtzPausedTriggerGrpsId) ) return false;
		 QrtzPausedTriggerGrpsId castOther = ( QrtzPausedTriggerGrpsId ) other; 
         
		 return ( (this.getSchedName()==castOther.getSchedName()) || ( this.getSchedName()!=null && castOther.getSchedName()!=null && this.getSchedName().equals(castOther.getSchedName()) ) )
 && ( (this.getTriggerGroup()==castOther.getTriggerGroup()) || ( this.getTriggerGroup()!=null && castOther.getTriggerGroup()!=null && this.getTriggerGroup().equals(castOther.getTriggerGroup()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSchedName() == null ? 0 : this.getSchedName().hashCode() );
         result = 37 * result + ( getTriggerGroup() == null ? 0 : this.getTriggerGroup().hashCode() );
         return result;
   }   


}


