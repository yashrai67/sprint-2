package org.cap.apps.freelancerapp.util;

import org.cap.apps.freelancerapp.adminms.dto.AdminDetails;
import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Component
public class AdmintUtil {

	public List<AdminDetails> toDetails(Collection<Admin> admins) {
		List<AdminDetails> desired = new ArrayList<>();
		for (Admin admin : admins) {
			AdminDetails details = toDetails(admin);
			desired.add(details);
		}
		return desired;
	}

	public AdminDetails toDetails(Admin admin) {
		AdminDetails details = new AdminDetails(admin.getId(), admin.getFirstName(), admin.getLastName(),
				admin.getPassword());
		return details;

	}
}
