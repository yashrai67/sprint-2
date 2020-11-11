package org.cap.apps.freelancerapp.jobapplicationms.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.cap.apps.freelancerapp.exceptions.JobApplicationNotFoundException;
import org.cap.apps.freelancerapp.exceptions.JobNotActiveException;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
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

@ExtendWith({ SpringExtension.class })
@DataJpaTest
@Import(JobApplicationServiceImpl.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class JobApplicationServiceImplTest {

	@Autowired
	IJobApplicationService service;

	@Autowired
	private EntityManager entityManager;

	@Test
	public void testApplytoJob() {
		String skillName = "Java";
		String description = "Java Fullstack";
		Skill skill = new Skill(skillName, description);
		entityManager.persist(skill);
		Recruiter postedBy = new Recruiter();
		entityManager.persist(postedBy);
		LocalDate postedDate = LocalDate.parse("2019-11-01");
		Boolean active = true;
		Job job = new Job();
		job.setActive(active);
		job.setPostedBy(postedBy);
		job.setSkill(skill);
		job.setPostedDate(postedDate);
		entityManager.persist(job);
		String coverLetter = "I have good technical skill";
		String fName = "Aniket";
		String lName = "Aniket";
		String pass = "Aniket123";
		Freelancer freelancer = new Freelancer(fName, lName, pass);
		entityManager.persist(freelancer);
		JobApplication jobApplication = service.applyToJob(job, coverLetter, freelancer);
		TypedQuery<JobApplication> query = entityManager.createQuery("from JobApplication", JobApplication.class);
		List<JobApplication> jobApplicationList = query.getResultList();
		JobApplication storedJobApplication = jobApplicationList.get(0);
		Assertions.assertEquals(jobApplication.getId(), storedJobApplication.getId());
		Assertions.assertEquals(jobApplication.getJob(), storedJobApplication.getJob());
		Assertions.assertEquals(jobApplication.getCoverLetter(), storedJobApplication.getCoverLetter());
		Assertions.assertEquals(jobApplication.getFreelancer(), storedJobApplication.getFreelancer());

	}

	@Test
	public void testFindById() {
		Executable executable = () -> service.findById(23L);
		Assertions.assertThrows(JobApplicationNotFoundException.class, executable);

		
	}

	@Test
	public void testApplytoJob_2() {
		String skillName = "Java";
		String description = "Java Fullstack";
		Skill skill = new Skill(skillName, description);
		entityManager.persist(skill);
		Recruiter postedBy = new Recruiter();
		entityManager.persist(postedBy);
		LocalDate postedDate = LocalDate.of(2020, 10, 23);
		Boolean active = false;
		Job job = new Job();
		job.setActive(active);
		job.setPostedBy(postedBy);
		job.setSkill(skill);
		job.setPostedDate(postedDate);
		entityManager.persist(job);
		String coverLetter = "I have good technical skill";
		String fName = "Aniket";
		String lName = "Aniket";
		String pass = "Aniket123";
		Freelancer freelancer = new Freelancer(fName, lName, pass);
		entityManager.persist(freelancer);
		Executable executable = () -> service.applyToJob(job, coverLetter, freelancer);
		Assertions.assertThrows(JobNotActiveException.class, executable);
	}

}
