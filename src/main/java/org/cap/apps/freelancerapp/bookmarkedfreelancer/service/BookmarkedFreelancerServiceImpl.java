package org.cap.apps.freelancerapp.bookmarkedfreelancer.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.cap.apps.freelancerapp.bookmarkedfreelancer.dao.IBookmarkedFreelancerDao;
import org.cap.apps.freelancerapp.bookmarkedfreelancer.entities.BookmarkedFreelancer;
import org.cap.apps.freelancerapp.exceptions.BookmarkedFreelancerNotFoundException;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class BookmarkedFreelancerServiceImpl implements IBookmarkedFreelancerService{
	@Autowired
	private IBookmarkedFreelancerDao dao;

	@Override
	public BookmarkedFreelancer bookmarkFreelancer(Freelancer freelancer, Skill skill, Recruiter bookmarkedBy) {
		BookmarkedFreelancer bookmarkedFreelancer = new BookmarkedFreelancer();
		bookmarkedFreelancer.setSkill(skill);
		bookmarkedFreelancer.setFreelancer(freelancer);
		bookmarkedFreelancer.setBookMarkedby(bookmarkedBy);
		bookmarkedFreelancer = dao.save(bookmarkedFreelancer);

		return bookmarkedFreelancer;
		
	}

	@Override
	public List<BookmarkedFreelancer> findBookmarkedFreelancersBySkill(Skill skill, Recruiter bookmarkedBy) {
	List<BookmarkedFreelancer> bookmarkedList=dao.findBySkillAndFreelancer(skill, bookmarkedBy);
		return bookmarkedList;
	}

	@Override
	public void removeBookmarkedFreelancer(Freelancer freelancer, Skill skill, Recruiter bookmarkedBy) {
		
		BookmarkedFreelancer bookmarkedFreelancer = dao.findBookmarkedFreelancerByFreelancerAndSkillAndBookmarkedBy(freelancer,skill,bookmarkedBy);
		dao.delete(bookmarkedFreelancer);
	}
	
	@Override
	public BookmarkedFreelancer findById(Long id) {
		Optional<BookmarkedFreelancer> optional = dao.findById(id);
		if (!optional.isPresent()) {
			throw new BookmarkedFreelancerNotFoundException("Student not found");
		}

		return optional.get();
	}
	

}
