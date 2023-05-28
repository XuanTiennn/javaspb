package com.example.learn.controller;


import com.example.learn.model.User;
import com.example.learn.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        // Validate user data
        // Check if the email is already taken
        if (userService.getUserByEmail(user.getEmail()) != null) {
            return ResponseEntity.badRequest().body("Email is already taken");
        }

        // Save the user
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        // Validate user data
        // Check if the email is already taken
        User userInfo = userService.getUserByEmail(user.getEmail());
        if ( user == null) {
            return ResponseEntity.badRequest().body("Email is not found");
        }
        return ResponseEntity.ok(userInfo);
    }

    // Other user-related endpoints
}

