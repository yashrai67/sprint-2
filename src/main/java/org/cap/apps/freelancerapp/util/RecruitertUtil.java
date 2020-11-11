package org.cap.apps.freelancerapp.util;

import org.cap.apps.freelancerapp.recruiterms.dto.RecruiterDetails;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class RecruitertUtil {
	public List<RecruiterDetails> toDetails(Collection<Recruiter> recruiters) {
		List<RecruiterDetails> desired = new ArrayList<>();
		for (Recruiter recruiter : recruiters) {
			RecruiterDetails details = toDetails(recruiter);
			desired.add(details);
		}
		return desired;
	}

	public RecruiterDetails toDetails(Recruiter recruiter) {
		RecruiterDetails details = new RecruiterDetails(recruiter.getId(), recruiter.getFirstName(),
				recruiter.getLastName(), recruiter.getPassword());
		return details;

	}
}
