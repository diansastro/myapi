package com.ghost.myapi.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer

/**
 * Created by widi (widiytk@gmail.com) on 2021-07-15.
 **/

@Configuration
@EnableResourceServer
class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "myapi-server-resource-id"
    private static final String SECURED_READ_SCOPE = "#oauth2.hasScope('read')"
    private static final String SECURED_WRITE_SCOPE = "#oauth2.hasScope('write')"
    private static final String SECURED_ADMIN_SCOPE = "#oauth2.hasScope('admin')"
    private static final String SECURED_STAFF_SCOPE = "#oauth2.hasScope('staff')"
    private static final String SECURED_STUDENT_SCOPE = "#oauth2.hasScope('student')"
    private static final String SECURED_LECTURER_SCOPE = "#oauth2.hasScope('lecturer')"
    private static final String SECURED_PATTERN = "/**"

    @Override
    void configure(ResourceServerSecurityConfigurer resourceServerSecurityConfigurer) {
        resourceServerSecurityConfigurer.resourceId(RESOURCE_ID)
    }

    @Override
    void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
        .antMatchers("/").permitAll()
        .antMatchers("/auth**").permitAll()
        .antMatchers("/auth/**").permitAll()
        .antMatchers(SECURED_PATTERN).access(SECURED_WRITE_SCOPE)
        .antMatchers(SECURED_PATTERN).access(SECURED_READ_SCOPE)
        .antMatchers("/admin**").access(SECURED_ADMIN_SCOPE)
        .antMatchers("/admin/**").access(SECURED_ADMIN_SCOPE)
        .antMatchers("/staff**").access(SECURED_STAFF_SCOPE)
        .antMatchers("/staff/**").access(SECURED_STAFF_SCOPE)
        .antMatchers("/student**").access(SECURED_STUDENT_SCOPE)
        .antMatchers("/student/**").access(SECURED_STUDENT_SCOPE)
        .antMatchers("/lecturer**").access(SECURED_LECTURER_SCOPE)
        .antMatchers("/lecturer/**").access(SECURED_LECTURER_SCOPE)
    }

}
