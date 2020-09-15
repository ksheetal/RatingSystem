package com.example.oyeRickshaw.Config;
/*
 * @created 15/09/2020 - 8:19 AM
 * @project oyeRickshaw
 * @author  sheetalkumar
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html").authenticated()
                .antMatchers("/v2/api-docs").authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {



        // changing because of spring updates
        String userName = "oye123";
        String password = "oye123@Api";

        //   System.out.println("\n\nUserName - " + userName + " Password - " + password);
        auth.inMemoryAuthentication()
                .withUser(userName).password("{noop}" + password).roles("ADMIN"); //or .roles("USER")

    }
}

