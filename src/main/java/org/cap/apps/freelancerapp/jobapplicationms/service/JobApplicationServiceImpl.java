package org.cap.apps.freelancerapp.jobapplicationms.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.cap.apps.freelancerapp.exceptions.JobApplicationNotFoundException;
import org.cap.apps.freelancerapp.exceptions.JobNotActiveException;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobapplicationms.dao.IJobApplicationDao;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class JobApplicationServiceImpl implements IJobApplicationService {

	@Autowired
	private IJobApplicationDao dao;

	@Override
	public JobApplication applyToJob(Job job, String coverLetter, Freelancer freelancer) {
		if(!job.getActive()) {
			throw new JobNotActiveException("Applied Job is not Active");
		}
		LocalDate appliedDate = LocalDate.now();
		JobApplication jobApplication = new JobApplication();
		jobApplication.setAppliedDate(appliedDate);
		jobApplication.setJob(job);
		jobApplication.setCoverLetter(coverLetter);
		jobApplication.setFreelancer(freelancer);
		jobApplication = dao.save(jobApplication);
		List<JobApplication>applications=job.getJobApplications();
		if(applications==null) {
			applications=new ArrayList<>();
			job.setJobApplications(applications);
		}
		applications.add(jobApplication);
		return jobApplication;

	
	}

	@Override
	public JobApplication updateJobApplication(Long id, Job job, String coverLetter, Freelancer freelancer) {
		JobApplication jobApplication = findById(id);
		LocalDate appliedDate = LocalDate.now();
		jobApplication.setAppliedDate(appliedDate);
		jobApplication.setJob(job);
		jobApplication.setCoverLetter(coverLetter);
		jobApplication.setFreelancer(freelancer);
		jobApplication = dao.save(jobApplication);
		return jobApplication;
	}

	@Override
	public void remove(Job job, Freelancer freelancer) {
		Long jobId=job.getId();
		Long freelancerId=freelancer.getId();
		JobApplication jobApplication = dao.findByJobFreelancer(jobId, freelancerId);
		dao.delete(jobApplication);
	}

	@Override
	public JobApplication findById(Long id) {
		Optional<JobApplication> optional = dao.findById(id);
		if (!optional.isPresent()) {
			throw new JobApplicationNotFoundException("Can't update, JobApplication not found");
		}

		return optional.get();
	}

}