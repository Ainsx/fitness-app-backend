package com.fitnessapp.dto;

public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest() {
        // for @RequestBody deserialization
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

// Data Transfer Object
// carries structured data between layers of my app
// If you don't have this and use full User Entity directly,
// frontend gets serialized of every field that User Entity have
// My API - How my backend talks to the outside world
// API (Application Programming interface)
// API communicates entirely through JSON
