package org.cap.apps.freelancerapp.bookmarkedfreelancer.dto;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

public class UpdateBookmarkedFreelancer { 
	
	private Long id;
	
	private Long skillId;
	
	private Long freelancerId;
	
	private Long bookmarkedById;

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

	public Long getFreelancerId() {
		return freelancerId;
	}

	public void setFreelancerId(Long freelancerId) {
		this.freelancerId = freelancerId;
	}

	public Long getBookmarkedById() {
		return bookmarkedById;
	}

	public void setBookmarkedById(Long bookmarkedById) {
		this.bookmarkedById = bookmarkedById;
	}



}
