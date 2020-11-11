package org.cap.apps.freelancerapp.bookmarkedfreelancer.controller;

import java.util.List;

import org.cap.apps.freelancerapp.bookmarkedfreelancer.dto.BookmarkedFreelancerDetails;
import org.cap.apps.freelancerapp.bookmarkedfreelancer.dto.BookmarkedFreelancerRequest;
import org.cap.apps.freelancerapp.bookmarkedfreelancer.entities.BookmarkedFreelancer;
import org.cap.apps.freelancerapp.bookmarkedfreelancer.service.IBookmarkedFreelancerService;
import org.cap.apps.freelancerapp.bookmarkedfreelancer.util.BookmarkedFreelancerUtil;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.freelancerms.service.IFreelancerService;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.recruiterms.service.IRecruiterService;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.skillms.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/bookmarkedfreelancers")
@RestController
public class BookmarkedFreelancerController {
	
	@Autowired
	private IBookmarkedFreelancerService service;
	@Autowired
	private IRecruiterService recruiterService;
	@Autowired
	private IFreelancerService freelancerService;
	@Autowired
	private ISkillService skillService;
	@Autowired
	private BookmarkedFreelancerUtil bookmarkedFreelancerUtil;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public BookmarkedFreelancerDetails  bookmarkFreelancer(@RequestBody BookmarkedFreelancerRequest requestData) {
		BookmarkedFreelancer bookmarkedFreelancer = new BookmarkedFreelancer();
		Recruiter recruiter = recruiterService.findById(requestData.getBookmarkedById());
		Freelancer freelancer = freelancerService.findById(requestData.getFreelancerId());
		Skill skill = skillService.findById(requestData.getSkillId());
		bookmarkedFreelancer.setBookMarkedby(recruiter);
		bookmarkedFreelancer.setFreelancer(freelancer);
		bookmarkedFreelancer.setSkill(skill);
		BookmarkedFreelancerDetails details = bookmarkedFreelancerUtil.toDetails(bookmarkedFreelancer);
		return details;
	}
	@GetMapping("/by/skill/{id}")
	public List<BookmarkedFreelancerDetails> fetchBookmarkedFreelancersBySkill(@PathVariable("id") Long skillId, Recruiter bookmarkedBy) {
		Skill skill = skillService.findById(skillId);
		List<BookmarkedFreelancer> bookmarkedFreelancer = service.findBookmarkedFreelancersBySkill(skill,bookmarkedBy);
		List<BookmarkedFreelancerDetails> bookmarkedList = bookmarkedFreelancerUtil.toDetails(bookmarkedFreelancer);
		return bookmarkedList;
	}
	
	
	@DeleteMapping("/remove/{freelancer}/{skill}/{recruiter}")
	public String removeBookmarkedFreelancer(@PathVariable("freelancer") Long freelancerId,@PathVariable("skill") Long skillId,@PathVariable("recruiter") Long recruiterId) {
		
		Freelancer freelancer = freelancerService.findById(freelancerId);
		Recruiter recruiter = recruiterService.findById(recruiterId);
		Skill skill = skillService.findById(skillId);
		service.removeBookmarkedFreelancer(freelancer,skill,recruiter);
		String response = "Bookmarked Freelancer removed with freelancer"+freelancer+"with skill"+skill+"with recruiter"+recruiter;
		return response;
	}
	
	
	
	
	@GetMapping("/by/id/{id}")
	public BookmarkedFreelancerDetails fetchBookmarkedFreelancer(@PathVariable("id") Long id) {
		BookmarkedFreelancer bookmarkedFreelancer = service.findById(id);
		BookmarkedFreelancerDetails details = bookmarkedFreelancerUtil.toDetails(bookmarkedFreelancer);
		return details;
	}
}
