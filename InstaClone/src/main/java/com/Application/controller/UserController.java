package com.Application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Application.modals.User;
import com.Application.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create new user (registration)
    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

//    // Update user
//    @PutMapping("/{userId}")
//    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
//        User user = userService.updateUser(userId, updatedUser);
//        if (user != null) {
//            return ResponseEntity.ok(user);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    // Delete user
//    @DeleteMapping("/{userId}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
//        userService.deleteUser(userId);
//        return ResponseEntity.ok().build();
//    }
}
