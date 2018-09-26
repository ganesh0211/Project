package org.usermanagement.core.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Spring Web MVC Security Java Config Demo Project
 * Configures Spring MVC stuffs.
 *
 * @author www.codejava.net
 */
@Configuration
@EnableWebMvc
@ComponentScan({"org.usermanagement.core.*"})
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean(name={"viewResolver"})
    public InternalResourceViewResolver getViewResolver() {
        System.out.println("\n\n\n MVC Config Started \n\n\n");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        System.out.println("\n\n\n MVC Config Ended \n\n\n");
        return viewResolver;
    }
    /*
* Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
*/
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler(new String[] { "/static/**" }).addResourceLocations(new String[] { "/static/" });
        registry.addResourceHandler(new String[] { "/oauth/**" }).addResourceLocations(new String[] { "/static/" });
    }

    public void addFormatters(FormatterRegistry registry){
        super.addFormatters(registry);
    }

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    public void configurePathMatch(PathMatchConfigurer matcher){
        matcher.setUseRegisteredSuffixPatternMatch(Boolean.valueOf(true));
    }

}
