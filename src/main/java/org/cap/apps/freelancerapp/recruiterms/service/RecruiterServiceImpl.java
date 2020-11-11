package org.cap.apps.freelancerapp.recruiterms.service;

import org.cap.apps.freelancerapp.exceptions.RecruiterNotFoundException;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.recruiterms.dao.IRecruiterDao;
import org.cap.apps.freelancerapp.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RecruiterServiceImpl implements IRecruiterService {
    @Autowired
    private IRecruiterDao recruiterRepository;

    @Override
    public Recruiter save(Recruiter recruiter) {
        ValidationUtil.checkArgumentNotNull(recruiter);
        ValidationUtil.checkFirstName(recruiter.getFirstName());
        ValidationUtil.checkLastName(recruiter.getLastName());
        recruiter = recruiterRepository.save(recruiter);
        return recruiter;
    }

    @Override
    public Recruiter findById(Long id) {
        Optional<Recruiter> optional = recruiterRepository.findById(id);
        if (!optional.isPresent()) {
            throw new RecruiterNotFoundException("recruiter not found exception = " + id);
        }
        return optional.get();
    }

    @Override
    public Recruiter update(Recruiter recruiter) {
        ValidationUtil.checkArgumentNotNull(recruiter);
        ValidationUtil.checkFirstName(recruiter.getFirstName());
        ValidationUtil.checkLastName(recruiter.getLastName());
        recruiter = recruiterRepository.save(recruiter);
        return recruiter;
    }

    @Override
    public void deleteById(Long id) {
        recruiterRepository.deleteById(id);
    }

}


