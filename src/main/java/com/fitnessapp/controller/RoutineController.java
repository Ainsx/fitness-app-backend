package com.fitnessapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routines")
public class RoutineController {

    @GetMapping
    public ResponseEntity<String> getRoutines() {
        return ResponseEntity.ok("🔐 This is a protected /routines endpoint!");
    }
}