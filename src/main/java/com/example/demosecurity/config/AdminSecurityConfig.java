package com.example.demosecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

/**
 * Created by mohd.waseem on 21/06/20.
 */
@Configuration
@Order(50)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().disable().antMatcher("/admin/**").
                addFilter(getDigestAuthFilter()).exceptionHandling()
                .authenticationEntryPoint(getDigestEntryPoint())
                .and().authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN");
    }

    private DigestAuthenticationFilter getDigestAuthFilter() throws Exception {
        DigestAuthenticationFilter digestFilter = new DigestAuthenticationFilter();
        digestFilter.setUserDetailsService(userDetailsServiceBean());
        digestFilter.setAuthenticationEntryPoint(getDigestEntryPoint());
        return digestFilter;
    }

    private DigestAuthenticationEntryPoint getDigestEntryPoint() {
        DigestAuthenticationEntryPoint digestEntryPoint = new DigestAuthenticationEntryPoint();
        digestEntryPoint.setRealmName("admin-digest-realm");
        digestEntryPoint.setKey("fjkf33DD312_+");
        return digestEntryPoint;
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }
}
