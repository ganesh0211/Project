package org.model.scheduler;
// Generated 26 Sep, 2018 8:49:36 PM by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * QrtzBlobTriggers generated by hbm2java
 */
@Entity
@Table(name="qrtz_blob_triggers"
    ,catalog="USERMANAGER"
)
public class QrtzBlobTriggers  implements java.io.Serializable {


     private QrtzBlobTriggersId id;
     private byte[] blobData;

    public QrtzBlobTriggers() {
    }

	
    public QrtzBlobTriggers(QrtzBlobTriggersId id) {
        this.id = id;
    }
    public QrtzBlobTriggers(QrtzBlobTriggersId id, byte[] blobData) {
       this.id = id;
       this.blobData = blobData;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="schedName", column=@Column(name="SCHED_NAME", nullable=false, length=120) ), 
        @AttributeOverride(name="triggerName", column=@Column(name="TRIGGER_NAME", nullable=false, length=200) ), 
        @AttributeOverride(name="triggerGroup", column=@Column(name="TRIGGER_GROUP", nullable=false, length=200) ) } )
    public QrtzBlobTriggersId getId() {
        return this.id;
    }
    
    public void setId(QrtzBlobTriggersId id) {
        this.id = id;
    }
    
    @Column(name="BLOB_DATA")
    public byte[] getBlobData() {
        return this.blobData;
    }
    
    public void setBlobData(byte[] blobData) {
        this.blobData = blobData;
    }




}


