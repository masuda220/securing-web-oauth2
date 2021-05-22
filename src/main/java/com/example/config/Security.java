package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(urlRegistry -> urlRegistry
                        .antMatchers("/", "/error").permitAll()
                        .anyRequest().authenticated()
                )
                .logout(logoutConfigurer -> logoutConfigurer
                        .logoutSuccessUrl("/").permitAll()
                )
                // 401 Unauthorized を返す
//                .exceptionHandling(exceptionHandlingConfigurer -> exceptionHandlingConfigurer
//                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                )
                .oauth2Login();
    }
}
