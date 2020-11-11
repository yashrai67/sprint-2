package org.cap.apps.freelancerapp.jobms.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cap.apps.freelancerapp.jobms.dto.JobDetails;
import org.cap.apps.freelancerapp.jobms.entities.Job;
import org.springframework.stereotype.Component;

@Component
public class JobUtil {

	public JobDetails toDetails(Job job) {
		JobDetails details = new JobDetails(job.getId(), job.getSkill().getId(), job.getPostedBy().getId(),
				job.getPostedDate(), job.getActive(), job.getJobApplications());
		return details;
	}

	public List<JobDetails> toDetails(Collection<Job> jobs) {
		List<JobDetails> jobList = new ArrayList<>();
		for (Job job : jobs) {
			JobDetails details = toDetails(job);
			jobList.add(details);
		}
		return jobList;
	}
	

}
