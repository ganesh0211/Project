package org.usermanagement.core.model.impl;

import org.usermanagement.core.model.Simple;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 9/4/17
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public class SimpleImpl implements Simple {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public long getId() {
        return id;
    }

    public long setId(long id) {
        this.id = id;
        return this.id;
    }

}
