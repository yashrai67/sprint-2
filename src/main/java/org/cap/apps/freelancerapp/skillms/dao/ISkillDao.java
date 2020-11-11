package org.cap.apps.freelancerapp.skillms.dao;

import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISkillDao extends JpaRepository<Skill, Long> {

}
