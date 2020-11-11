package org.cap.apps.freelancerapp.freelancerms.dao;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFreelancerDao extends JpaRepository<Freelancer, Long> {
    Freelancer findFreelancerByfirstName(String lastName);
    Freelancer findFreelancerBylastName(String lastName);
}
