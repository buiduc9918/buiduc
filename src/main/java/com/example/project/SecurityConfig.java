package com.example.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configure in-memory user authentication
        auth.inMemoryAuthentication()
            .withUser("user")
            .password("{noop}password") // Use {noop} prefix to specify plaintext password (not recommended for production)
            .roles("USER");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/login").permitAll() // Allow access to login page without authentication
                .requestMatchers("/dashboard").hasRole("USER") // Require "USER" role to access the dashboard
                .requestMatchers("/admin").hasRole("ADMIN") // Require "ADMIN" role to access the admin page
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
            // http.headers(null).frameOptions().Origin();
            return http.build();
    }
}