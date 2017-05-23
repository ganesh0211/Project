package org.model.usermanagement;

import org.usermanagement.core.model.impl.CoreImpl;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 17/5/17
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "PERMISSION")
public class Permission extends CoreImpl {

    @ManyToOne
    private PermissionSet permissionSet;
}
