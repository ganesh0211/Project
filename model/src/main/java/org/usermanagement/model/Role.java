package org.usermanagement.model;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: ganesh
 * Date: 13/5/16
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="Role")
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
