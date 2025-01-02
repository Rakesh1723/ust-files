package com.ust.app.authservice.api;

import com.ust.app.authservice.model.UserModel;
import com.ust.app.authservice.service.UserCurdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserCurdService userService;

    @PostMapping
    public UserModel createUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }


}
