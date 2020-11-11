package org.cap.apps.freelancerapp.jobms.dto;

import java.time.LocalDate;
import java.util.List;

import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

public class JobDetails {

private Long id;
	
	private Long skillId;

	private Long recruiterId;
	private LocalDate postedDate;
	// private Freelancer awardedTo;
	private Boolean active;
	
	private List<JobApplication> jobApplications;
	
	public JobDetails(Long id, Long skillId, Long recruiterId, LocalDate postedDate, Boolean active,
			List<JobApplication> jobApplications) {
		super();
		this.id = id;
		this.skillId = skillId;
		this.recruiterId = recruiterId;
		this.postedDate = postedDate;
		this.active = active;
		this.jobApplications = jobApplications;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public Long getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}

	public LocalDate getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		this.postedDate = postedDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<JobApplication> getJobApplications() {
		return jobApplications;
	}

	public void setJobApplications(List<JobApplication> jobApplications) {
		this.jobApplications = jobApplications;
	}
	
	
	
	
}
