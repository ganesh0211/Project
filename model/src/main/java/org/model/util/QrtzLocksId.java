package org.model.util;
// Generated 2 Oct, 2018 11:19:34 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QrtzLocksId generated by hbm2java
 */
@Embeddable
public class QrtzLocksId  implements java.io.Serializable {


     private String schedName;
     private String lockName;

    public QrtzLocksId() {
    }

    public QrtzLocksId(String schedName, String lockName) {
       this.schedName = schedName;
       this.lockName = lockName;
    }
   

    @Column(name="SCHED_NAME", nullable=false, length=120)
    public String getSchedName() {
        return this.schedName;
    }
    
    public void setSchedName(String schedName) {
        this.schedName = schedName;
    }

    @Column(name="LOCK_NAME", nullable=false, length=40)
    public String getLockName() {
        return this.lockName;
    }
    
    public void setLockName(String lockName) {
        this.lockName = lockName;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof QrtzLocksId) ) return false;
		 QrtzLocksId castOther = ( QrtzLocksId ) other; 
         
		 return ( (this.getSchedName()==castOther.getSchedName()) || ( this.getSchedName()!=null && castOther.getSchedName()!=null && this.getSchedName().equals(castOther.getSchedName()) ) )
 && ( (this.getLockName()==castOther.getLockName()) || ( this.getLockName()!=null && castOther.getLockName()!=null && this.getLockName().equals(castOther.getLockName()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSchedName() == null ? 0 : this.getSchedName().hashCode() );
         result = 37 * result + ( getLockName() == null ? 0 : this.getLockName().hashCode() );
         return result;
   }   


}


