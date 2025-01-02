package com.ust.app.springsecurity.service;

import com.ust.app.springsecurity.model.UserModel;
import com.ust.app.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepo.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("Username Doesn't Exist"));
        return new UserDetailsImpl(user);

    }

    public UserDetails saveUser(UserModel model){
        PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        model.setPassword(passwordEncoder.encode(model.getPassword()));
        return new UserDetailsImpl(userRepo.save(model));
    }
}
