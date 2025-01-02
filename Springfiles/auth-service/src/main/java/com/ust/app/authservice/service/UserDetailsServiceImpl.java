package com.ust.app.authservice.service;

import com.ust.app.authservice.model.UserModel;
import com.ust.app.authservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService{
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel=userRepository.findByUsername(username)
                          .orElseThrow(()->new UsernameNotFoundException("user not found"));
        return new UserDetailsImpl(userModel);
    }
}
