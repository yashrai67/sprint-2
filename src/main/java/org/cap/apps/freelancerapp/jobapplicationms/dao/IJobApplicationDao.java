package org.cap.apps.freelancerapp.jobapplicationms.dao;

import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IJobApplicationDao extends JpaRepository<JobApplication, Long>{
	
    @Query("from JobApplication where job_id=:job and freelancer_id=:freelancer")
    JobApplication findByJobFreelancer(@Param("job") Long jobId,@Param("freelancer") Long freelancerId);
    
    
}
