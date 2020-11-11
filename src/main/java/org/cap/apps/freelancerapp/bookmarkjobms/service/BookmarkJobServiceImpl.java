package org.cap.apps.freelancerapp.bookmarkjobms.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.cap.apps.freelancerapp.bookmarkjobms.dao.BookmarkedJobDaoImpl;
import org.cap.apps.freelancerapp.bookmarkjobms.dao.IBookmarkJobDao;
import org.cap.apps.freelancerapp.bookmarkjobms.entities.BookmarkedJob;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.util.JpaUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class BookmarkJobServiceImpl implements IBookmarkJobService {
	@Autowired
	private IBookmarkJobDao dao;


	@Override
	public BookmarkedJob bookmarkJob(Job job, Freelancer freelancer) {
	return null;
	}

	@Override
	public List<BookmarkedJob> findBookmarkedJobsBySkill(Skill skill, Freelancer freelancer) {
		List<BookmarkedJob> list = dao.findBookmarkedJobsBySkill(skill, freelancer);

		return list;
	}

	@Override
	public void removeBookmark(Job job, Freelancer freelancer) {
	}

}