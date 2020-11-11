package org.cap.apps.freelancerapp.jobms.dto;

public class CreateJobRequest {
	private Long recruiterId;
	private Long skillId;
	
	
	
	public Long getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(Long recruiterId) {
		this.recruiterId = recruiterId;
	}
	public Long getSkillId() {
		return skillId;
	}
	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}
	

	
}
