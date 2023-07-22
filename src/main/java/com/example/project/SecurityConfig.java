package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configure in-memory user authentication
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}password") // Use {noop} prefix to specify plaintext password (not recommended for production)
            .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/login").permitAll() // Allow access to login page without authentication
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login") // Specify the custom login page URL
            .defaultSuccessUrl("/dashboard") // Redirect to the dashboard after successful login
            .and()
            .logout()
            .logoutUrl("/logout") // Specify the custom logout URL
            .logoutSuccessUrl("/login") // Redirect to the login page after successful logout
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID");
    }
}