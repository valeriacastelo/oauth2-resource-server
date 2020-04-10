package com.example.oauth2resourceserver.configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                authorizeRequests.antMatchers(HttpMethod.GET, "/access/read/**").hasAuthority("SCOPE_read")
                                 .antMatchers(HttpMethod.POST, "/access/write/**").hasAuthority("SCOPE_write")
                                 .anyRequest().authenticated())
                .oauth2ResourceServer().jwt();
    }
}
