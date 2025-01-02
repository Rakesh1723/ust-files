package com.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
         // 1.lambda way
//        http.csrf(customizer->customizer.disable());
//        http.authorizeHttpRequests(request->request.anyRequest().permitAll());
//        // http.formLogin(Customizer.withDefaults()); // from sec
//        http.httpBasic(Customizer.withDefaults()); //from http
//        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // 2.imperative way
        /*
         * Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new
         * Customizer<CsrfConfigurer<HttpSecurity>>() {
         *
         * @Override public void customize(CsrfConfigurer<HttpSecurity> configurer) {
         *
         * configurer.disable(); } };
         *
         * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
         * AuthorizationManagerRequestMatcherRegistry> custHttp = new
         * Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
         * AuthorizationManagerRequestMatcherRegistry>() {
         *
         * @Override public void customize(
         * AuthorizeHttpRequestsConfigurer<HttpSecurity>.
         * AuthorizationManagerRequestMatcherRegistry registry) {
         * registry.anyRequest().authenticated();
         *
         * } };
         *
         * http.authorizeHttpRequests(custHttp); http.csrf(custCsrf);
         */

        http.csrf(customizer -> customizer.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/registers","/login")
                        .permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//        http.authorizeHttpRequests(auth->auth.anyRequest().authenticated())
//                .oauth2Login(Customizer.withDefaults());

        return http.build();
    }

    // static in memory userDetails impl
//    @Bean
//    public UserDetailsService userDetailsService(){
//            // user is build using Builder pattern
//        UserDetails user= User
//                          .withDefaultPasswordEncoder()
//                          .username("user")
//                          .password("user123")
//                          .roles("USER")
//                          .build();
//        UserDetails admin= User
//                .withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin123")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }

    // Dynamic impl
    @Bean
    public AuthenticationProvider authProvider(){

         DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
         provider.setUserDetailsService(userDetailsService);
//         provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
         provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

}
