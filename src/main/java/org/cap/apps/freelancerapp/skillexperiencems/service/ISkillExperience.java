package org.cap.apps.freelancerapp.skillexperiencems.service;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.skillexperiencems.entities.SkillExperience;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

public interface ISkillExperience {
    SkillExperience addSkill(Skill skill, Freelancer freelancer, int experienceYears);
    SkillExperience updateSkill(Skill skill,  Freelancer freelancer, int experienceYears);

}
