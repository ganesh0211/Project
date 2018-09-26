package org.model.usermanagement;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 12:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PERSISTENT_LOGINS")
public class PersistentLogin {
    @Id
    private String series;
    @Column(name = "USERNAME", unique = true, nullable = false)
    private String username;
    @Column(name = "TOKEN", unique = true, nullable = false)
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private Date last_used;

    public PersistentLogin() {
    }

    public String getSeries() {
        return this.series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLast_used() {
        return this.last_used;
    }

    public void setLast_used(Date last_used) {
        this.last_used = last_used;
    }
}
