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
}