package org.cap.apps.freelancerapp.jobms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.cap.apps.freelancerapp.exceptions.JobNotFoundException;
import org.cap.apps.freelancerapp.jobms.dao.IJobDao;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class JobServiceImpl implements IJobService {
	@Autowired
	private IJobDao dao;
	
	

	@Override
	public Job postJob(Skill skill, Recruiter recruiter) {
		Job job = new Job();
		LocalDate postedDate = LocalDate.now();
		job.setPostedDate(postedDate);
		job.setPostedBy(recruiter);
		Boolean active = true;
		job.setActive(active);
		job.setSkill(skill);
		job = dao.save(job);
		return job;
	}
	

	@Override
	public Job findById(Long id) {
		Optional<Job> optional = dao.findById(id);
		if (!optional.isPresent()) {
			throw new JobNotFoundException("Can't update, Job not found");
		}
		Job job=optional.get();
		return job;

	}

	@Override
	public List<Job> findJobBySkill(Skill skill) {
		Long skillId=skill.getId();
		List<Job> list = dao.findJobsBySkill(skillId);
		return list;

	}

	@Override
	public Job updateJob(Job job) {
		Long id = job.getId();
		Job newJob = findById(id);
		newJob = dao.save(job);
		return newJob;
	}

	@Override
	public void close(Job job) {
		job.setActive(false);
		updateJob(job);

	}

}