package org.usermanagement.core.model.impl;

import org.usermanagement.core.model.Observer;
import org.usermanagement.core.model.Simple;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 9/4/17
 * Time: 12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class ObserverSimpleImpl implements Simple, Observer {
    @Override
    public long getId() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long setId(long id) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
