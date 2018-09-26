package org.usermanagement.core.ui.impl;

import org.springframework.stereotype.Component;
import org.usermanagement.core.ui.TypeRegistry;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class TypeRegistryImpl implements TypeRegistry {

    private Set<String> typeRegister = new HashSet();

    @PostConstruct
    public void init()
    {
        register("java.lang.String");
        register("java.lang.Enum");
        register("java.util.List");
        register("java.util.Set");
        register("int");
        register("java.lang.Integer");
        register("long");
        register("java.lang.Long");
        register("boolean");
        register("java.lang.Boolean");
        register("double");
        register("java.lang.Double");
        register("java.util.Date");
    }

    @Override
    public void register(String type) {
        this.typeRegister.add(type);
    }

    @Override
    public boolean isRegistered(String type) {
        return this.typeRegister.contains(type);
    }

    @Override
    public void remove(String type) {
        this.typeRegister.remove(type);
    }
}
