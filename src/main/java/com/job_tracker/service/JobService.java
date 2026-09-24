package com.job_tracker.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.job_tracker.Job;
import com.job_tracker.Repository.JobRepository;
import com.job_tracker.exception.JobNotFoundException;
@Service
public class JobService {
    public final JobRepository JobRepository;

    public JobService(JobRepository JobRepository){
        this.JobRepository=JobRepository;
    }


    public Job createJob(Job job) {
        return JobRepository.save(job);
    }

    public List<Job> getAllJobs(){
        return JobRepository.findAll();
    }

    public Job getJobById(Long id) {
        return JobRepository.findById(id).orElseThrow(() ->
                    new JobNotFoundException("Job not found with id: " + id));
}

    public void deleteJob(Long id) {
        JobRepository.deleteById(id);
    }

    public Job updateJob(Long id, Job updatedJob) {
        Job existingJob = JobRepository.findById(id).orElse(null);
        if(existingJob == null) {
            return null;
        }
        existingJob.setCompany(updatedJob.getCompany());
        existingJob.setRole(updatedJob.getRole());
        existingJob.setStatus(updatedJob.getStatus());
        return JobRepository.save(existingJob);
    }

}