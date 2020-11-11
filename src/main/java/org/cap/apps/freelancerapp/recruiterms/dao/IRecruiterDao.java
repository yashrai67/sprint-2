package org.cap.apps.freelancerapp.recruiterms.dao;

import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecruiterDao extends JpaRepository<Recruiter, Long> {
}
