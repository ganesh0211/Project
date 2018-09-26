package org.usermanagement.core.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 2:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class MvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    public MvcInitializer() {}

    protected Class<?>[] getRootConfigClasses(){
        return new Class[] { MvcConfig.class };
    }

    protected Class<?>[] getServletConfigClasses(){
        return null;
    }

    protected String[] getServletMappings(){
        return new String[] { "/" };
    }

    protected Filter[] getServletFilters(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        return new Filter[] { characterEncodingFilter, new DecoratorConfigFilter() };
    }
}
