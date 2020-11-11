package org.cap.apps.freelancerapp.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.cap.apps.freelancerapp.freelancerms.dto.FreelancerDetails;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.springframework.stereotype.Component;

@Component
public class FreelancerUtil {
    public List<FreelancerDetails> toDetails(Collection<Freelancer> freelancers) {
        List<FreelancerDetails> desired = new ArrayList<>();
        for (Freelancer freelancer : freelancers) {
            FreelancerDetails details = toDetails(freelancer);
            desired.add(details);
        }
        return desired;
    }

    public FreelancerDetails toDetails(Freelancer freelancer) {
        FreelancerDetails details = new FreelancerDetails(freelancer.getId(), freelancer.getFirstName(), freelancer.getLastName(), freelancer.getPassword());
        return details;

    }
}
