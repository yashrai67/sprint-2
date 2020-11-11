package org.cap.apps.freelancerapp.jobapplicationms.dto;


public class JobApplicationDetails {

	private Long id;

	private Long jobId;

	private String appliedDate;

	private String coverLetter;

	private Long freelancerId;

	public JobApplicationDetails() {
		super();

	}
	
	public JobApplicationDetails(Long id, Long jobId, String appliedDate, String coverLetter,
			Long freelancerId) {
		super();
		this.id = id;
		this.jobId = jobId;
		this.appliedDate = appliedDate;
		this.coverLetter = coverLetter;
		this.freelancerId = freelancerId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(String appliedDate) {
		this.appliedDate = appliedDate;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public Long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(Long freelancerId) {
		this.freelancerId = freelancerId;
	}

	
}
