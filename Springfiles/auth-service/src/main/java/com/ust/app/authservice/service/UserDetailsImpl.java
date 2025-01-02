package com.ust.app.authservice.service;

import com.ust.app.authservice.model.UserModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;


public class UserDetailsImpl implements UserDetails {

    private String username;
    private String password;
    private String role;

    public UserDetailsImpl(UserModel user){
        this.username=user.getUsername();
        this.password=user.getPassword();
        this.role=user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+role);
//         return List.of(authority);

        return Arrays.stream(role.split(","))
                .map(String::trim)
                .map(String::toUpperCase)
                .map(r->"ROLE_"+r)
                .map(SimpleGrantedAuthority::new)
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
