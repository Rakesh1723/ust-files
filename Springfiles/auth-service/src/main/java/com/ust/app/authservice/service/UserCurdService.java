package com.ust.app.authservice.service;

import com.ust.app.authservice.model.UserModel;

import java.util.Optional;

public interface UserCurdService {
    public UserModel saveUser(UserModel user);
}
