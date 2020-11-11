package org.cap.apps.freelancerapp.skillms.util;


import org.cap.apps.freelancerapp.skillms.dto.SkillDetails;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.springframework.stereotype.Component;

@Component
public class SkillUtil {
	
	public SkillDetails toDetails(Skill skill) {
		SkillDetails details = new SkillDetails(skill.getId(),skill.getName(),skill.getDescription());
		return details;
	}
	

}
