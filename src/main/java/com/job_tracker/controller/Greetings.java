package com.job_tracker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Greetings {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Job Tracker application";
    }
}

