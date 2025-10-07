package com.fitnessapp.controller;

import com.fitnessapp.dto.AuthResponse;
import com.fitnessapp.dto.LoginRequest;
import com.fitnessapp.model.User;
import com.fitnessapp.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Reponsibilities : Accept Requests/return responses
@RestController // "This class will handle HTTP requests and return JSON responses"
@RequestMapping("/auth") // now endpoints are /auth/register and /auth/login
public class AuthController {
    private final AuthService authService;// dependency
    // "This controller depends on a service called AuthService to handle the actul
    // logic"

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // register endpoint (POST http://localhost:8080/auth/register)
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        authService.registerUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    // login endpoint
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        String token = authService.login(request.getEmail(), request.getPassword());
        System.out.println("login reached");
        // String token = authService.login(user.getEmail(), user.getPassword());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
