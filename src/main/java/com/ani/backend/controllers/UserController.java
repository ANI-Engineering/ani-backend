package com.ani.backend.controllers;

import com.ani.backend.dao.User;
import com.ani.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/allowed")
    public ResponseEntity<Map<String, Object>> getUserPermissions(@RequestParam String email) {
        User user = userService.getUserTypeAndPermissions(email);
        if (user != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("userType", user.getUserType());
            response.put("permissions", user.getPermissions());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
