package com.ust.app.springsecurity.config;

import com.ust.app.springsecurity.util.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.persistence.Access;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(req->{
//            req.requestMatchers("/api/public").permitAll();
//            req.anyRequest().authenticated();
//        });
//        http.formLogin(AbstractHttpConfigurer::disable);
//        http.httpBasic(Customizer.withDefaults());
//        return http.build();
//    }

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthFilter authFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

          auth.userDetailsService(userDetailsService);

//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("$2a$12$6VNeAf2CNX1SsVpDeB65SunD5RfnnUQQHUTQ61lHSIoYbvyTwVzN2")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user = User.builder()
//                .username("USER")
//                .password("$2a$12$EbCYTojKcOJ57WrytHbwB.n64MmxWAz3QYPZNdKpcYvCkTWToerhe")
//                .roles("USER")
//                .build();
//
//        auth.inMemoryAuthentication().withUser(admin)
//                .withUser(user);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/api/public/**").permitAll()
                .antMatchers("/api/secured/**").hasRole("user")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}


//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        UserDetails user= User
//                .withDefaultPasswordEncoder()
//                .username("user")
//                .password("user123")
//                .roles("USER")
//                .build();
//        UserDetails admin= User
//                .withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin123")
//                .roles("ADMIN")
//                .build();
//
//
//        auth.inMemoryAuthentication()
//                .withUser(user)
//                .withUser(admin);
//
////        auth.inMemoryAuthentication()
////                  .withUser("user")
////                .password("password")
////                .roles("ADMIN");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests()
//                .antMatchers("/api/app/admin/**").hasRole("ADMIN")
//                .antMatchers("/api/app/**").hasAnyRole("ADMIN","USER")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin().and()
//                .csrf().disable()
//        ;
//
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//}



