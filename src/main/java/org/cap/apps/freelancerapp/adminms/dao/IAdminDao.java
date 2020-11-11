package org.cap.apps.freelancerapp.adminms.dao;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminDao extends JpaRepository<Admin, Long> {
    Admin findAdminByfirstName(String lastName);
    Admin findAdminBylastName(String lastName);
}

