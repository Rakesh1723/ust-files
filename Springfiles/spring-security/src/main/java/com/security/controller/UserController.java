package com.security.controller;


import com.security.model.Users;
import com.security.repository.UserRepository;
import com.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    @PostMapping("/registers")
    public Users addStudent(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user)
    {
        Authentication  authentication= authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        else
            return "Login failed";


    }

}
