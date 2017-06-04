package org.usermanagement.core.model.impl;

import org.usermanagement.core.model.Observer;
import org.usermanagement.core.model.Simple;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 9/4/17
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ObserverSimpleImpl implements Simple, Observer {

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
