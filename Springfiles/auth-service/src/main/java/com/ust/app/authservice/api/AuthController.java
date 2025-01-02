package com.ust.app.authservice.api;

import com.ust.app.authservice.dto.JwtToken;
import com.ust.app.authservice.dto.UserCredentials;
import com.ust.app.authservice.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public JwtToken login(@RequestBody UserCredentials userCredentials){
        return authenticationService.loginUser(userCredentials);
    }
}
