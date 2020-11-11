package org.cap.apps.freelancerapp.adminms.service;

import org.cap.apps.freelancerapp.adminms.entities.Admin;

import java.util.List;

public interface IAdminService {
    Admin save(Admin admin);
    Admin update(Admin admin);
    Admin findById(Long id);
    void deleteById(Long id);
}
