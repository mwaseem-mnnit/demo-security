package com.example.demosecurity.config;

import com.example.demosecurity.filter.CsrfTokenResponseHeaderBindingFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 * Created by mohd.waseem on 21/06/20.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout();

        // CSRF tokens handling
        http.addFilterAfter(new CsrfTokenResponseHeaderBindingFilter(), CsrfFilter.class);
    }
}
