package org.cap.apps.freelancerapp.bookmarkedfreelancer.dto;

public class BookmarkedFreelancerDetails {
	
	

	private Long id;
	
	private Long skillId;
	
	private Long freelancerId;
	
	private Long bookmarkedById;
	
	public BookmarkedFreelancerDetails() {

	}
	
	public BookmarkedFreelancerDetails(Long id, Long skillId,Long freelancerId,Long bookmarkedById) {
		super();
		this.id = id;
		this.skillId = skillId;
		this.freelancerId = freelancerId;
		this.bookmarkedById = bookmarkedById;
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
