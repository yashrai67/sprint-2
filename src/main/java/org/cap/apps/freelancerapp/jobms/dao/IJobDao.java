package org.cap.apps.freelancerapp.jobms.dao;

import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobDao extends JpaRepository<Job, Long>{

	@Query("from Job where skill_id=:skillId")
    List<Job>findJobsBySkill(Long skillId);

	
}
