package com.ani.backend.service;

import com.ani.backend.dao.User;
import com.ani.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserTypeAndPermissions(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user;
        } else {
            throw new RuntimeException("User not found with email: " + email);
        }
    }
}
