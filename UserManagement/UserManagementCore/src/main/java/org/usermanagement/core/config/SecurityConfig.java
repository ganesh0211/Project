package org.usermanagement.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Web MVC Security Java Config Demo Project
 * Configures authentication and authorization for the application.
 *
 * @author www.codejava.net
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.print("\n\n\nSecurity Config Loader called **************************\n\n\n");
        auth.inMemoryAuthentication().withUser("ganesh").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("vasudha").password("abc").roles("USER");

        System.out.println("\n\n\n Security Config Loader Ended \n\n\n");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("\n\n\n Security Config Configure Started \n\n\n");
      /*http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/admin**").access("hasRole('ADMIN')")
        .and().formLogin();
       
      http.csrf().disable();     */
        http.authorizeRequests().antMatchers("/static/css/**", "static/css/**", "/static/**").permitAll();
        http.authorizeRequests().antMatchers("/login", "/saveDummyRootUser").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/**").authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/home")
                .usernameParameter("ssoId").passwordParameter("password").and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
        System.out.println("\n\n\n Security Config Configure Ended \n\n\n");

    }
}