package org.model.util;
// Generated 2 Oct, 2018 11:19:34 AM by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * OauthClientDetails generated by hbm2java
 */
@Entity
@Table(name="oauth_client_details"
    ,catalog="USERMANAGER"
)
public class OauthClientDetails  implements java.io.Serializable {


     private String clientId;
     private String resourceIds;
     private String clientSecret;
     private String scope;
     private String authorizedGrantTypes;
     private String webServerRedirectUri;
     private String authorities;
     private Integer accessTokenValidity;
     private Integer refreshTokenValidity;
     private String additionalInformation;
     private String autoapprove;

    public OauthClientDetails() {
    }

	
    public OauthClientDetails(String clientId) {
        this.clientId = clientId;
    }
    public OauthClientDetails(String clientId, String resourceIds, String clientSecret, String scope, String authorizedGrantTypes, String webServerRedirectUri, String authorities, Integer accessTokenValidity, Integer refreshTokenValidity, String additionalInformation, String autoapprove) {
       this.clientId = clientId;
       this.resourceIds = resourceIds;
       this.clientSecret = clientSecret;
       this.scope = scope;
       this.authorizedGrantTypes = authorizedGrantTypes;
       this.webServerRedirectUri = webServerRedirectUri;
       this.authorities = authorities;
       this.accessTokenValidity = accessTokenValidity;
       this.refreshTokenValidity = refreshTokenValidity;
       this.additionalInformation = additionalInformation;
       this.autoapprove = autoapprove;
    }
   
     @Id 
    
    @Column(name="client_id", unique=true, nullable=false)
    public String getClientId() {
        return this.clientId;
    }
    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    @Column(name="resource_ids")
    public String getResourceIds() {
        return this.resourceIds;
    }
    
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }
    
    @Column(name="client_secret")
    public String getClientSecret() {
        return this.clientSecret;
    }
    
    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
    
    @Column(name="scope")
    public String getScope() {
        return this.scope;
    }
    
    public void setScope(String scope) {
        this.scope = scope;
    }
    
    @Column(name="authorized_grant_types")
    public String getAuthorizedGrantTypes() {
        return this.authorizedGrantTypes;
    }
    
    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }
    
    @Column(name="web_server_redirect_uri")
    public String getWebServerRedirectUri() {
        return this.webServerRedirectUri;
    }
    
    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }
    
    @Column(name="authorities")
    public String getAuthorities() {
        return this.authorities;
    }
    
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
    
    @Column(name="access_token_validity")
    public Integer getAccessTokenValidity() {
        return this.accessTokenValidity;
    }
    
    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }
    
    @Column(name="refresh_token_validity")
    public Integer getRefreshTokenValidity() {
        return this.refreshTokenValidity;
    }
    
    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }
    
    @Column(name="additional_information", length=4096)
    public String getAdditionalInformation() {
        return this.additionalInformation;
    }
    
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
    
    @Column(name="autoapprove")
    public String getAutoapprove() {
        return this.autoapprove;
    }
    
    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }




}


