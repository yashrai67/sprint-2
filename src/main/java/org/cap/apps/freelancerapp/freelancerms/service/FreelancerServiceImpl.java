package org.cap.apps.freelancerapp.freelancerms.service;

import javax.transaction.Transactional;
import org.cap.apps.freelancerapp.exceptions.FreelancerNotFoundException;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.freelancerms.dao.IFreelancerDao;
import org.cap.apps.freelancerapp.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@Service
public class FreelancerServiceImpl implements IFreelancerService {
	
	@Autowired
	private IFreelancerDao freelancerRepository;

	@Override
	public Freelancer save(Freelancer freelancer) {
		ValidationUtil.checkArgumentNotNull(freelancer);
		ValidationUtil.checkFirstName(freelancer.getFirstName());
		ValidationUtil.checkLastName(freelancer.getLastName());
		freelancer = freelancerRepository.save(freelancer);
		return freelancer;
	}

	@Override
	public Freelancer findById(Long id) {
		 Optional<Freelancer>optional= freelancerRepository.findById(id);
	       if(!optional.isPresent()){
	       throw new FreelancerNotFoundException("user not found for id="+id);
	       }
	        return optional.get();
	}

	@Override
	public Freelancer update(Freelancer freelancer){
		 ValidationUtil.checkArgumentNotNull(freelancer);
		 ValidationUtil.checkFirstName(freelancer.getFirstName());
		 ValidationUtil.checkLastName(freelancer.getLastName());
		 freelancer=freelancerRepository.save(freelancer);
	     return freelancer;
	}

	@Override
	public void deleteById(Long id) {
		freelancerRepository.deleteById(id);
	}



}