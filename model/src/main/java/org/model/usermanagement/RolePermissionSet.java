package org.model.usermanagement;

import org.usermanagement.core.model.impl.SimpleImpl;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 17/5/17
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ROLEPERMISSIONSET")
public class RolePermissionSet extends SimpleImpl {

    @ManyToOne(targetEntity = Role.class)
    private Role role;
    @ManyToOne(targetEntity = PermissionSet.class)
    private PermissionSet permissionSet;
}
