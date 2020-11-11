package org.cap.apps.freelancerapp.bookmarkedfreelancer.dao;

import java.util.List;

import org.cap.apps.freelancerapp.bookmarkedfreelancer.entities.BookmarkedFreelancer;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface IBookmarkedFreelancerDao extends JpaRepository<BookmarkedFreelancer, Long>{
	
	@Query("from BookmarkedFreelancer where skill_id=:skill and recruiter_id=:recruiter")
	List<BookmarkedFreelancer> findBySkillAndFreelancer(Skill skill,Recruiter recruiter);

	BookmarkedFreelancer findBookmarkedFreelancerByFreelancerAndSkillAndBookmarkedBy(Freelancer freelancer, Skill skill, Recruiter bookmarkedBy); 
}
