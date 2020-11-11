package org.cap.apps.freelancerapp.bookmarkedfreelancer.service;


import java.util.List;

import org.cap.apps.freelancerapp.bookmarkedfreelancer.entities.BookmarkedFreelancer;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

public interface IBookmarkedFreelancerService {
	
    BookmarkedFreelancer bookmarkFreelancer(Freelancer freelancer,Skill skill,Recruiter recruiter) ;

    List<BookmarkedFreelancer> findBookmarkedFreelancersBySkill(Skill skill, Recruiter recruiter) ;

    void removeBookmarkedFreelancer(Freelancer freelancer,Skill skill,Recruiter recruiter);

	BookmarkedFreelancer findById(Long id);

}