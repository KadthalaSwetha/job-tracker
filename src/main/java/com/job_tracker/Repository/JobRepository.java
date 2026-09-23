package com.job_tracker.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.job_tracker.Job;
public interface JobRepository extends JpaRepository<Job, Long>{

}
