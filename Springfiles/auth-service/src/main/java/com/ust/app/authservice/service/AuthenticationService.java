package com.ust.app.authservice.service;

import com.ust.app.authservice.dto.JwtToken;
import com.ust.app.authservice.dto.UserCredentials;
import com.ust.app.authservice.model.UserModel;
import com.ust.app.authservice.repository.UserRepository;
import com.ust.app.authservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public JwtToken loginUser(UserCredentials userCredentials){
        UserModel userModel=userRepository.findByUsername(userCredentials.username())
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
         if(!passwordEncoder.matches(userCredentials.password(),userModel.getPassword())){ //raw pass, en pass
            throw  new RuntimeException("Invalid Credentials");
         }
         String jwt=jwtUtil.generateToken(userCredentials.username());
         return new JwtToken(jwt);
    }
}
