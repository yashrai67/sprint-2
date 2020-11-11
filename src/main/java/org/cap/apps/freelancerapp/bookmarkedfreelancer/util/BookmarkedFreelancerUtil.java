package org.cap.apps.freelancerapp.bookmarkedfreelancer.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cap.apps.freelancerapp.bookmarkedfreelancer.dto.BookmarkedFreelancerDetails;
import org.cap.apps.freelancerapp.bookmarkedfreelancer.entities.BookmarkedFreelancer;
import org.springframework.stereotype.Component;
@Component
public class BookmarkedFreelancerUtil {
	
	public BookmarkedFreelancerDetails toDetails(BookmarkedFreelancer bookmarkedFreelancer) {
		
		BookmarkedFreelancerDetails details = new BookmarkedFreelancerDetails(bookmarkedFreelancer.getId(),bookmarkedFreelancer.getSkill().getId(),bookmarkedFreelancer.getFreelancer().getId(),bookmarkedFreelancer.getBookMarkedby().getId());
		
		return details;
	}
	
	public List<BookmarkedFreelancerDetails> toDetails(Collection<BookmarkedFreelancer> bookmarkedFreelancer){
		List<BookmarkedFreelancerDetails> bookmarkedList=new ArrayList<>();
		for(BookmarkedFreelancer bookmarked:bookmarkedFreelancer) {
			BookmarkedFreelancerDetails details=toDetails(bookmarked);
			bookmarkedList.add(details);
		}
		return bookmarkedList;
	}
	
	

}
