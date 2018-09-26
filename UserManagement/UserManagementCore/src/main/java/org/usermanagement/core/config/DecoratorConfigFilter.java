package org.usermanagement.core.config;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class DecoratorConfigFilter extends SiteMeshFilter {
    public DecoratorConfigFilter() {}

    public void doFilter(ServletRequest rq, ServletResponse rs, FilterChain chain)
            throws IOException, ServletException
    {
        super.doFilter(rq, rs, chain);
    }
}
