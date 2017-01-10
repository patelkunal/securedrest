package org.coderearth.securedrest.jwtsecurity.config;

import org.coderearth.securedrest.jwtsecurity.custom.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by kunal_patel on 12/30/16.
 */
@EnableWebSecurity
@ComponentScan("org.coderearth.securedrest.jwtsecurity")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationTokenFilter tokenFilter;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .csrf()
                    .disable()
                .exceptionHandling()
                    .authenticationEntryPoint(authEntryPoint())
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    .antMatchers("/auth/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .addFilterBefore(this.tokenFilter, UsernamePasswordAuthenticationFilter.class)
        ;
        // @formatter:on
    }

    @Bean
    protected AuthenticationEntryPoint authEntryPoint() {
        return new Http403ForbiddenEntryPoint();
    }
}
