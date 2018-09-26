package org.usermanagement.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationManager;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * Created with IntelliJ IDEA.
 * User: ganes
 * Date: 26/9/18
 * Time: 2:52 PM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {
    public static final String RESOURCE_ID = "UserManagement";
    @Autowired
    private AuthenticationManager oAuth2authenticationManager;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private UserApprovalHandler userApprovalHandler;
    @Autowired
    private ClientDetailsService clientDetailsService;
    @Autowired
    private DefaultAccessTokenConverter defaultAccessTokenConverter;

    public OAuth2Config() {}

    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception
    {
        endpoints.accessTokenConverter(this.defaultAccessTokenConverter).tokenStore(this.tokenStore).userApprovalHandler(this.userApprovalHandler).authenticationManager(this.oAuth2authenticationManager);
    }

    public void configure(AuthorizationServerSecurityConfigurer oauthServer)
            throws Exception
    {
        oauthServer.checkTokenAccess("permitAll()");
    }

    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception
    {
        clients.withClientDetails(this.clientDetailsService);
    }

    @Bean
    @Autowired
    public AuthenticationManager oAuth2authenticationManager(ClientDetailsService clientDetailsService, ResourceServerTokenServices resourceServerTokenServices)
    {
        OAuth2AuthenticationManager oAuth2authenticationManager = new OAuth2AuthenticationManager();
        oAuth2authenticationManager.setClientDetailsService(clientDetailsService);
        oAuth2authenticationManager.setTokenServices(resourceServerTokenServices);
        return oAuth2authenticationManager;
    }

    @Bean
    @Autowired
    public ClientDetailsService clientDetailsService(@Qualifier("defaultDataSource") DataSource dataSource, @Qualifier("passwordEncoder") PasswordEncoder passwordEncoder)
    {
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        clientDetailsService.setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }

    @Bean
    @Autowired
    public ResourceServerTokenServices resourceServerTokenServices(ClientDetailsService clientDetailsService, TokenStore tokenStore)
    {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setClientDetailsService(clientDetailsService);
        defaultTokenServices.setTokenStore(tokenStore);
        defaultTokenServices.setSupportRefreshToken(true);
        return defaultTokenServices;
    }

    @Bean
    @Autowired
    public TokenStore tokenStore(@Qualifier("defaultDataSource") DataSource dataSource, AuthenticationKeyGenerator authenticationKeyGenerator)
    {
        JdbcTokenStore tokenStore = new JdbcTokenStore(dataSource);
        tokenStore.setAuthenticationKeyGenerator(authenticationKeyGenerator);
        return tokenStore;
    }

    @Bean
    public AuthenticationKeyGenerator authenticationKeyGenerator()
    {
        return new CustomAuthenticationKeyGenerator("SHA-256");
    }

    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(DefaultOAuth2RequestFactory defaultOAuth2RequestFactory, TokenStore tokenStore, ClientDetailsService clientDetailsService)
    {
        TokenStoreUserApprovalHandler tokenStoreUserApprovalHandler = new TokenStoreUserApprovalHandler();
        tokenStoreUserApprovalHandler.setRequestFactory(defaultOAuth2RequestFactory);
        tokenStoreUserApprovalHandler.setTokenStore(tokenStore);
        tokenStoreUserApprovalHandler.setClientDetailsService(clientDetailsService);
        return tokenStoreUserApprovalHandler;
    }

    @Bean
    @Autowired
    public DefaultOAuth2RequestFactory defaultOAuth2RequestFactory(ClientDetailsService clientDetailsService)
    {
        return new DefaultOAuth2RequestFactory(clientDetailsService);
    }

    @Bean
    public DefaultAccessTokenConverter defaultAccessTokenConverter()
    {
        return new DefaultAccessTokenConverter();
    }
}
