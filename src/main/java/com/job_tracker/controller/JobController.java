package com.job_tracker.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.job_tracker.Job;
@RestController
public class JobController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Job Tracker application";
    }

     @GetMapping("/jobs")
    public String getJobs() {
        return "Here are your jobs";
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        return "Job created for "+ job.getCompany();
    }

}