package com.job_tracker.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job_tracker.Job;
import com.job_tracker.service.JobService;
@RestController
public class JobController {
    private final JobService jobService;
    public JobController(JobService jobService){
        this.jobService=jobService;
    }


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Job Tracker application";
    }

     @GetMapping("/jobs")
    public String getJobs() {
        return "Here are your jobs";
    }

    @GetMapping("/jobs/{id}")
    public String getJobById(@PathVariable int id){
        return "you requested for the jobs with id :"+id;
    }

    @GetMapping("/jobs/search")
    public String status(@RequestParam String status){
        return "Searching jobs with status:" +status;
    }

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        return jobService.createJob(job);
    }

}