package com.security.repository;

import com.security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByUsername(String userName);
}
