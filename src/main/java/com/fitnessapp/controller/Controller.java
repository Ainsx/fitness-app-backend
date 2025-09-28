package com.fitnessapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Ready for use by Spring MVC (model view controller)
public class Controller {

    @GetMapping("/") // maps / into the index method
    public String index() {
        return "Start of Fitness app Beta ";
    }

}
