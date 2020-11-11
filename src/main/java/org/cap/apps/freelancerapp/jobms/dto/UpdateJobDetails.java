package org.cap.apps.freelancerapp.jobms.dto;

public class UpdateJobDetails {
	private Long id;
	
	private Long skillId;

	private Long recruiterId;
	private String postedDate;
	private Boolean active;
	
	
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
	public String getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	

	
}
