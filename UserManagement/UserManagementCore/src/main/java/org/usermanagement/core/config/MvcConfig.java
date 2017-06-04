package org.usermanagement.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring Web MVC Security Java Config Demo Project
 * Configures Spring MVC stuffs.
 *
 * @author www.codejava.net
 */
@Configuration
@ComponentScan("org.usermanagement.core.*")
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        System.out.println("\n\n\n MVC Config Started \n\n\n");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        System.out.println("\n\n\n MVC Config Ended \n\n\n");
        return viewResolver;
    }

    /*
public ViewResolver viewResolver() {
System.out.print("\n\n\nMVC" +
" Config Loader called **************************\n\n\n");
InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
viewResolver.setViewClass(JstlView.class);
viewResolver.setPrefix("/WEB-INF/views/");
viewResolver.setSuffix(".jsp");
return viewResolver;
}

/*
* Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.print("\n\n\nRegister handler******\n\n");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/css/");
    }

}
