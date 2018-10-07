package org.usermanagement.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.annotation.Jsr250Voter;
import org.springframework.security.access.vote.UnanimousBased;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;

import java.util.ArrayList;
import java.util.List;

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
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private PersistentTokenRepository tokenRepository;

    public SecurityConfig() {}

    @DependsOn({"userDetailsService"})
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception {
        System.out.println("\n\n\n Security Config Configure Started \n\n\n");
        http.authorizeRequests().antMatchers("/login","/saveDummyRootUser", "/error/**", "/static/**").permitAll();
        http.authorizeRequests().antMatchers("/","/oauth2/**", "/home", "/userInfo/**").authenticated();
                http.formLogin().loginPage("/login").defaultSuccessUrl("/home")
                .usernameParameter("ssoId").passwordParameter("password").and()
                .rememberMe().rememberMeParameter("remember-me").tokenRepository(tokenRepository).tokenValiditySeconds(86400).and()
                .exceptionHandling().accessDeniedPage("/Access_Denied");
        http.csrf().disable();
        // CSRF tokens handling
        http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
        System.out.println("\n\n\n Security Config Configure Ended \n\n\n");
    }
    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.print("\n\n\nSecurity Config Loader called **************************\n\n\n");
        auth.inMemoryAuthentication().withUser("ganesh").password("123").roles("USER");
        auth.inMemoryAuthentication().withUser("vasudha").password("abc").roles("USER");

        System.out.println("\n\n\n Security Config Loader Ended \n\n\n");
    } */
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("\n\n\n Security Config Configure Started \n\n\n");
      /*http.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/admin**").access("hasRole('ADMIN')")
        .and().formLogin();
       
      http.csrf().disable();     */
       /* http.authorizeRequests().antMatchers("/static/css/**", "static/css/**", "/static/**").permitAll();
        http.authorizeRequests().antMatchers("/login", "/saveDummyRootUser").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/**").authenticated()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/home")
                .usernameParameter("ssoId").passwordParameter("password").and().csrf()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
        System.out.println("\n\n\n Security Config Configure Ended \n\n\n");

    }    */

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PersistentTokenBasedRememberMeServices getPersistentTokenBasedRememberMeServices(){
        PersistentTokenBasedRememberMeServices tokenBasedservice =
                new PersistentTokenBasedRememberMeServices("remember-me", userDetailsService, tokenRepository);
        return tokenBasedservice;
    }

    @Bean
    public AuthenticationTrustResolver getAuthenticationTrustResolver(){
        return new AuthenticationTrustResolverImpl();
    }

    @Bean
    public AccessDecisionManager accessDecisionManager()
    {
        List<AccessDecisionVoter<? extends Object>> accessDecisionVoterList = new ArrayList();
        AccessDecisionVoter decisionVoter = new Jsr250Voter();
        accessDecisionVoterList.add(decisionVoter);
        return new UnanimousBased(accessDecisionVoterList);
    }

}