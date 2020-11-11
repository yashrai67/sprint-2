package org.cap.apps.freelancerapp.bookmarkedfreelancer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

@Entity
@Table(name = "BookmarkedFreelancer")
public class BookmarkedFreelancer {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@ManyToOne
	private Skill skill;
	@ManyToOne
	private Freelancer freelancer;
	@ManyToOne
	private Recruiter bookmarkedBy;

	public BookmarkedFreelancer() {
		super();
	}

	public BookmarkedFreelancer( Skill skill, Freelancer freelancer, Recruiter bookMarkedby) {
		super();
		this.skill = skill;
		this.freelancer = freelancer;
		this.bookmarkedBy = bookMarkedby;
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	public Recruiter getBookMarkedby() {
		return bookmarkedBy;
	}

	public void setBookMarkedby(Recruiter bookMarkedby) {
		this.bookmarkedBy = bookMarkedby;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookmarkedFreelancer other = (BookmarkedFreelancer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}



	