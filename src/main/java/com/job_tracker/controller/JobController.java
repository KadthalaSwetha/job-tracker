package com.job_tracker.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job_tracker.Job;
import com.job_tracker.Service.JobService;
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
    public List<Job> getJobs() {
        return jobService.getAllJobs();
    }

   @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
    Job job = jobService.getJobById(id);
    return ResponseEntity.ok(job);
    }


    @GetMapping("/jobs/search")
    public String status(@RequestParam String status){
        return "Searching jobs with status:" +status;
    }

    @PostMapping("/jobs")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jobs/{id}")
    public Job updateJob(@PathVariable Long id, @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }

}