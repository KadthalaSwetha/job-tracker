package com.job_tracker.service;


import org.springframework.stereotype.Service;

import com.job_tracker.Job;
@Service
public class JobService {

    public String createJob(Job job) {
        return "Job created for " + job.getCompany();
    }
}