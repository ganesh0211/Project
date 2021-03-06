package org.model.util;
// Generated 2 Oct, 2018 11:19:34 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OauthApprovals generated by hbm2java
 */
@Entity
@Table(name="oauth_approvals"
    ,catalog="USERMANAGER"
)
public class OauthApprovals  implements java.io.Serializable {


     private OauthApprovalsId id;

    public OauthApprovals() {
    }

    public OauthApprovals(OauthApprovalsId id) {
       this.id = id;
    }
   
     @EmbeddedId
    
    @AttributeOverrides( {
        @AttributeOverride(name="userId", column=@Column(name="userId") ), 
        @AttributeOverride(name="clientId", column=@Column(name="clientId") ), 
        @AttributeOverride(name="scope", column=@Column(name="scope") ), 
        @AttributeOverride(name="status", column=@Column(name="status", length=10) ), 
        @AttributeOverride(name="expiresAt", column=@Column(name="expiresAt", nullable=false, length=0) ), 
        @AttributeOverride(name="lastModifiedAt", column=@Column(name="lastModifiedAt", nullable=false, length=0) ) } )
    public OauthApprovalsId getId() {
        return this.id;
    }
    
    public void setId(OauthApprovalsId id) {
        this.id = id;
    }




}


