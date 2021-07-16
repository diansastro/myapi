package com.ghost.myapi.config

import com.ghost.myapi.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore

import javax.sql.DataSource

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-15.
 **/

@Configuration
@EnableAuthorizationServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(ServerSecurityConfig.class)
class AuthServerOAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource

    @Autowired
    private AuthenticationManager authenticationManager

    @Autowired
    private UserService userService

    @Autowired
    private PasswordEncoder oauthClientPasswordEncoder

    @Bean
    TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource)
    }

    @Bean
    DefaultTokenServices tokenServices() {
        final DefaultTokenServices defaultTokenServices = new DefaultTokenServices()
        defaultTokenServices.setTokenStore(tokenStore())
        defaultTokenServices.setSupportRefreshToken(true)
        return defaultTokenServices
    }

    @Bean
    OAuth2AccessDeniedHandler oAuthAccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler()
    }

    @Override
    void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()")
        .checkTokenAccess("isAuthenticated()")
        .passwordEncoder(oauthClientPasswordEncoder)
    }

    @Override
    void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.jdbc(dataSource)
    }

    @Override
    void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore())
        .authenticationManager(authenticationManager)
        .userDetailsService(userService)
    }
}
