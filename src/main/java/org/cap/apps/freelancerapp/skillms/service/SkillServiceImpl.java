package org.cap.apps.freelancerapp.skillms.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.cap.apps.freelancerapp.skillms.dao.ISkillDao;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillServiceImpl implements ISkillService {
	@Autowired
	private ISkillDao skillDao;

	@Override
	public Skill save(Skill skill) {
		
		 skill = skillDao.save(skill);
		 return skill;
	}

	@Override
	public Skill update(Skill skill) {
		return null;
	}

	@Override
	public Skill remove(Skill skill) {
		return null;
	}

	@Override
	public Skill findById(Long id) {
	Optional<Skill> optional=skillDao.findById(id);
	return optional.get();
	
	
	}

	@Override
	public Skill findByName(String name) {
		return null;
	}

}
