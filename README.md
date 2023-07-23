# buiduc
22/7/2023
1.the project have a problem in SecurutyConfig i don't have any solution for import websecurity .
2. I đon't have anyway using it like a web page with html . i can't connect with service layer .
thanks for all.
23/7
someone else help me this method in securityconfig.java in src/java/project/.:
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
this method have a froblem about :
The method authorizeRequests() from the type HttpSecurity is deprecated
The method permitAll() from the type ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl is deprecated
The method hasRole(String) from the type ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl is deprecated
The method hasRole(String) from the type ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl is deprecated
The method authenticated() from the type ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl is deprecated
The method and() from the type ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry is deprecated
The method formLogin() from the type HttpSecurity has been deprecated since version 6.1 and marked for removal
The method and() from the type SecurityConfigurerAdapter<DefaultSecurityFilterChain,HttpSecurity> has been deprecated since version 6.1 and marked for removal
The method logout() from the type HttpSecurity has been deprecated since version 6.1 and marked for removal
