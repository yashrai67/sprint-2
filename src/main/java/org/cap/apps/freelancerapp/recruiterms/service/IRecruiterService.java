package org.cap.apps.freelancerapp.recruiterms.service;

import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;

import java.util.List;

public interface IRecruiterService {
    Recruiter save(Recruiter recruiter);

    Recruiter findById(Long id);

    Recruiter update(Recruiter recruiter);

    void deleteById(Long id);

}
