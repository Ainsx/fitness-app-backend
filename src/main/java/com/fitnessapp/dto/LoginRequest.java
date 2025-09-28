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
