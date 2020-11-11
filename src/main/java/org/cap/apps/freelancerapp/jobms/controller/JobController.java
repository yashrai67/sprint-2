package org.cap.apps.freelancerapp.jobms.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.cap.apps.freelancerapp.jobms.dto.CreateJobRequest;
import org.cap.apps.freelancerapp.jobms.dto.JobDetails;
import org.cap.apps.freelancerapp.jobms.dto.UpdateJobDetails;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.jobms.service.IJobService;
import org.cap.apps.freelancerapp.jobms.util.JobUtil;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.recruiterms.service.IRecruiterService;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.skillms.service.ISkillService;
import org.cap.apps.freelancerapp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/jobs")
@RestController
public class JobController {

	@Autowired
	private IJobService service;
	
	@Autowired
	private IRecruiterService recruiterService;

	@Autowired
	private ISkillService skillService;

	@Autowired
	private JobUtil jobUtil;
	
	@Autowired
	private DateUtil dateUtil;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/postjob")
	public JobDetails postJob(@RequestBody CreateJobRequest requestData) {
		Recruiter recruiter=recruiterService.findById(requestData.getRecruiterId());
		Skill skill=skillService.findById(requestData.getSkillId());
		Job job = service.postJob(skill, recruiter);
		JobDetails details = jobUtil.toDetails(job);
		return details;
	}
	
	@PutMapping("/update")
	public JobDetails update(@RequestBody UpdateJobDetails requestData) {
		Job job=new Job();
		Skill skill=skillService.findById(requestData.getSkillId());
		Recruiter recruiter=recruiterService.findById(requestData.getRecruiterId());
		String date = requestData.getPostedDate();
		LocalDate localDate = dateUtil.localDate(date);
		job.setId(requestData.getId());
		job.setActive(requestData.getActive());
		job.setPostedBy(recruiter);
		job.setSkill(skill);
		job.setPostedDate(localDate);
		job = service.updateJob(job);
		JobDetails details = jobUtil.toDetails(job);
		return details;
	}

	@GetMapping("/by/id/{id}")
	public JobDetails fitchJob(@PathVariable("id") Long id) {
		Job job = service.findById(id);
		JobDetails details = jobUtil.toDetails(job);
		return details;
	}

	@GetMapping("/by/Skill/{id}")
	public List<JobDetails> fetchJobBySkill(@PathVariable("id") Long skillId) {
		Skill skill = skillService.findById(skillId);
		List<Job> jobs = service.findJobBySkill(skill);
		List<JobDetails> jobList = jobUtil.toDetails(jobs);
		return jobList;
	}

	@PutMapping("/close/job/{jobId}")
	public String closeJob(@PathVariable("jobId") Long jobId) {
		Job job = service.findById(jobId);
		service.close(job);
		String response = "Job is Closed" + job;
		return response;
	}

}
