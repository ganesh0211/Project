package org.usermanagement.core.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Spring Web MVC Security Java Config Demo Project
 * Bootstraps Spring Dispacher Servlet in Servlet 3.0+ environment.
 *
 * @author www.codejava.net
 */
public class SpringWebAppInitializer {/*implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("\n\n\n On Start Up Started \n\n\n");
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(MvcConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "Spring-Ganesh-Dispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        System.out.println("\n\n\n On Start Up Ended \n\n\n");
    }
          */
}