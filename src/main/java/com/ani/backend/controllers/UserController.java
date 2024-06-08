package com.ani.backend.controllers;

import com.ani.backend.dao.User;
import com.ani.backend.service.UserService;
import com.ani.backend.repositories.UserRepository;
import com.ani.backend.response.user.UserResponse;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/allowed")
    public ResponseEntity<Map<String, Object>> getUserPermissions(@RequestParam String email) {
        User user = userService.getUserTypeAndPermissions(email);
        if (user != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("userType", user.getUserType());
            response.put("permissions", user.getUserPermissions());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }
    @GetMapping("/get/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByEmail(email));
        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{email}")
    public ResponseEntity<User> updateUser(@PathVariable("email") String email, @RequestBody User user) {
        Optional<User> existingUserOptional = Optional.ofNullable(userRepository.findByEmail(email));

        if (existingUserOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User existingUser = existingUserOptional.get();
        if (user.getEmail() != null && !user.getEmail().equals(email)) {
            boolean emailExists = userRepository.existsByEmail(user.getEmail());
            if (emailExists) {
                throw new IllegalArgumentException("Email already exists");
            }
        }
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setContactCountryCode(user.getContactCountryCode());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setAltPhoneNumber(user.getAltPhoneNumber());
        existingUser.setDob(user.getDob());
        existingUser.setAddress(user.getAddress());
        existingUser.setCity(user.getCity());
        existingUser.setUserCreationDate(user.getUserCreationDate());
        existingUser.setUserStatus(user.getUserStatus());

        return ResponseEntity.ok(userRepository.save(existingUser));
    }
    @DeleteMapping("/delete/{email}")
    @Transactional
    public ResponseEntity<Void> deleteUserByEmail(@PathVariable("email") String email) {
        if (!userRepository.existsByEmail(email)) {
            return ResponseEntity.notFound().build();
        }

        userRepository.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/validateOtp")
    public ResponseEntity<?> validateOtp(@RequestParam("email") String email, @RequestParam("otp") String otp) {
      UserResponse userResponse = userService.validateOtpWithDetails(email,otp);
      if (userResponse != null) {
        return ResponseEntity.ok(userResponse);
      } else {
        return ResponseEntity.badRequest().body("Invalid OTP or OTP Expired");
      }
    }
}