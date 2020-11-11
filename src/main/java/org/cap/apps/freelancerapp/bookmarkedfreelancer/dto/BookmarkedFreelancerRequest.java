package org.cap.apps.freelancerapp.bookmarkedfreelancer.dto;

public class BookmarkedFreelancerRequest {
	
	private Long skillId;
	
	private Long freelancerId;
	
	private Long bookmarkedById;

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
