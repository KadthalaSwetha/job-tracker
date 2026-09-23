package com.job_tracker.service;


import org.springframework.stereotype.Service;

import com.job_tracker.Job;
import com.job_tracker.Repository.JobRepository;
@Service
public class JobService {
    public final JobRepository JobRepository;
    public JobService(JobRepository JobRepository){
        this.JobRepository=JobRepository;
    }


    public Job createJob(Job job) {
        return JobRepository.save(job);
    }
}