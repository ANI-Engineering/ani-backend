package com.ani.backend.controllers;

import com.ani.backend.dao.User;
import com.ani.backend.service.UserService;
import com.ani.backend.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        user.setUser_creation_date(new Date());
        User savedUser = userRepository.save(user);
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

        if (!existingUserOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        User existingUser = existingUserOptional.get();
        if (user.getEmail() != null && !user.getEmail().equals(email)) {
            boolean emailExists = userRepository.existsByEmail(user.getEmail());
            if (emailExists) {
                throw new IllegalArgumentException("Email already exists");
            }
        }
        existingUser.setFirst_name(user.getFirst_name());
        existingUser.setLast_name(user.getLast_name());
        existingUser.setContact_country_code(user.getContact_country_code());
        existingUser.setPhone_number(user.getPhone_number());
        existingUser.setAlt_contact_country_code(user.getAlt_contact_country_code());
        existingUser.setAlt_phone_number(user.getAlt_phone_number());
        existingUser.setDob(user.getDob());
        existingUser.setAddress(user.getAddress());
        existingUser.setCity(user.getCity());
        existingUser.setUser_creation_date(user.getUser_creation_date());
        existingUser.setUser_status(user.getUser_status());
        existingUser.setUserType(user.getUserType());

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
}


