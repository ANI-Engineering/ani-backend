package com.ani.backend.service;

import com.ani.backend.dao.User;
import com.ani.backend.response.user.UserResponse;
import com.ani.backend.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

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
    private String newId() {
        return UUID.randomUUID().toString();
    }
    public User createUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        user.setUserId(newId());
        user.setUserCreationDate(new Date());
        return userRepository.save(user);
    }
    public User validateOtp(String email, String otp) {
        @SuppressWarnings("null")
        User user = userRepository.findById(email).orElse(null);
        if (user != null && user.getOtp().equals(otp)) {
          if (isOtpValid(user.getOtpExpiry())) {
            return user;
          } else {
            return null;
          }
        }
        return null;
      }
      public UserResponse validateOtpWithDetails(String email, String otp) {
      User user = validateOtp(email, otp); 
      if (user != null) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setEmail(user.getEmail());
        userResponse.setPhoneNumber(user.getPhoneNumber());
        userResponse.setUserType(user.getUserType());
     
        return userResponse;
      }
      return null;
    }
      private boolean isOtpValid(LocalDateTime otpExpiry) {
        if (otpExpiry != null) {
          return otpExpiry.plusSeconds(120).isAfter(LocalDateTime.now());
        } else {
          return false; 
        }
      }
}
