package org.cap.apps.freelancerapp.jobms.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.cap.apps.freelancerapp.exceptions.JobNotFoundException;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith({SpringExtension.class})
@DataJpaTest
@Import(JobServiceImpl.class)
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class JobServiceImplTest {

	
	@Autowired
	IJobService service;
	
	@Autowired
	private EntityManager entityManager;
	
	@Test
	public void testPostJob() {
		String skillName="Java";
		String description="Java Fullstack";
		Skill skill = new Skill(skillName,description);
		entityManager.persist(skill);
		Recruiter recruiter=new Recruiter();
		entityManager.persist(recruiter);
		Job job=service.postJob(skill, recruiter);
		TypedQuery<Job> query=entityManager.createQuery("from Job",Job.class);
		List<Job> jobList=query.getResultList();
		Job storedJob=jobList.get(0);
		Assertions.assertEquals(job.getId(), storedJob.getId());
		Assertions.assertEquals(job.getSkill(), storedJob.getSkill());
		Assertions.assertEquals(job.getPostedBy(), storedJob.getPostedBy());
		
	}
	
	@Test
	public void testFindById() {
		Executable executable=()-> service.findById(23L);
		Assertions.assertThrows(JobNotFoundException.class, executable);
		
	}
	
	
}
