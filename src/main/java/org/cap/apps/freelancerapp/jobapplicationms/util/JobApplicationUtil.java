package org.cap.apps.freelancerapp.jobapplicationms.util;

import org.cap.apps.freelancerapp.jobapplicationms.dto.JobApplicationDetails;
import org.cap.apps.freelancerapp.jobapplicationms.entities.JobApplication;
import org.cap.apps.freelancerapp.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobApplicationUtil {
	
	@Autowired
	private DateUtil dateUtil;
	
	public JobApplicationDetails toDetails(JobApplication jobApplication) {
		String date=dateUtil.toDateText(jobApplication.getAppliedDate());
		
		JobApplicationDetails details = new JobApplicationDetails(jobApplication.getId(), jobApplication.getJob().getId(),date
				, jobApplication.getCoverLetter(), jobApplication.getFreelancer().getId());
		return details;
	}
}