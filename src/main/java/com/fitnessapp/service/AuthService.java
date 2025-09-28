package com.fitnessapp.service;

import java.util.ArrayList;
import com.fitnessapp.model.User;
import com.fitnessapp.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import com.fitnessapp.config.JwtUtil;

@Service
public class AuthService {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(JwtUtil jwtUtil, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    // Register : hash password, then save user
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));// user getter/setter
        userRepository.save(user);
    }

    // log in: check email and password
    public String login(String email, String rawPassword) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User Not found"));

        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        // TODO: return JWT
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), new ArrayList<>());
        return jwtUtil.generateToken(userDetails);
        // return "dummy-jwt-token-for-" + user.getEmail();
    }

}
