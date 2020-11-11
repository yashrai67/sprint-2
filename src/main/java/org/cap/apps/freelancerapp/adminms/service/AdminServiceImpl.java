package org.cap.apps.freelancerapp.adminms.service;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.adminms.dao.IAdminDao;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class AdminServiceImpl implements IAdminService{


	@Autowired
	private IAdminDao admindao;

	@Override
	public Admin save(Admin admin) {
		ValidationUtil.checkArgumentNotNull(admin);
		ValidationUtil.checkFirstName(admin.getFirstName());
		ValidationUtil.checkLastName(admin.getLastName());
		admin = admindao.save(admin);
		return admin;
	}

	@Override
	public Admin findById(Long id) {
		Optional<Admin>optional = admindao.findById(id);
		if(!optional.isPresent()) {
			throw new AdminNotFoundException("admin not found for id = " + id);
		}
		return optional.get();
	}

	@Override
	public Admin update(Admin admin){
		ValidationUtil.checkArgumentNotNull(admin);
		ValidationUtil.checkFirstName(admin.getFirstName());
		ValidationUtil.checkLastName(admin.getLastName());
		admin = admindao.save(admin);
		return admin;
	}

	@Override
	public void deleteById(Long id) {
		admindao.deleteById(id);
	}



}
