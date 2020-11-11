package org.cap.apps.freelancerapp.skillexperiencems.service;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.skillexperiencems.dao.ISkillExperienceDao;
import org.cap.apps.freelancerapp.skillexperiencems.entities.SkillExperience;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;

public class SkillExperienceService implements ISkillExperience {

    @Autowired
    private ISkillExperienceDao skillExperienceDao;

    @Override
    public SkillExperience addSkill(Skill skill, Freelancer freelancer, int experienceYears) {
        SkillExperience skillExperience = new SkillExperience();
        skillExperience.setFreelancer(freelancer);
        skillExperience.setYears(experienceYears);
        skillExperience.setId(skill.getId());

        return null;
    }

    @Override
    public SkillExperience updateSkill(Skill skill, Freelancer freelancer, int experienceYears) {
        return null;
    }
}
