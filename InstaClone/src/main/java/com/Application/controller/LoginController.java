package com.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Application.modals.User;
import com.Application.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByUsername(loginRequest.getUsername());
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return ResponseEntity.ok("Login Successful");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
    }
}

// LoginRequest DTO
class LoginRequest {
    private String username;
    private String password;

    // Getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    
}

