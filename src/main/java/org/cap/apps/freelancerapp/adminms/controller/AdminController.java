package org.cap.apps.freelancerapp.adminms.controller;

import org.cap.apps.freelancerapp.adminms.dto.AdminDetails;

import org.cap.apps.freelancerapp.adminms.dto.CreateAdminRequest;
import org.cap.apps.freelancerapp.adminms.dto.UpdateAdminRequest;
import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.adminms.service.IAdminService;
import org.cap.apps.freelancerapp.util.AdmintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@Validated
@RequestMapping("/admins")
@RestController
public class AdminController {
    @Autowired
    private IAdminService service;

    @Autowired
    private AdmintUtil adminUtil;
    
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public AdminDetails add(@RequestBody @Valid CreateAdminRequest requestData) {
        System.out.println("inside");
        Admin admin = new Admin(requestData.getFirstname(), requestData.getLastname(), requestData.getPassword());
        admin = service.save(admin);
        AdminDetails details = adminUtil.toDetails(admin);
        return details;
    }


    @PutMapping("/update")
    public AdminDetails update(@RequestBody @Valid UpdateAdminRequest requestData) {
        Admin admin =new Admin(requestData.getFirstname(), requestData.getLastname(),
                requestData.getPassword());
        admin.setId(requestData.getId());
        admin = service.update(admin);
        AdminDetails details = adminUtil.toDetails(admin);
        return details;
    }
    
    
    @GetMapping("/get/{id}")
    public AdminDetails fetchAdmin(@PathVariable("id") Long id) {
        Admin admin = service.findById(id);
        AdminDetails details = adminUtil.toDetails(admin);
        return details;
    }
    
    
    @DeleteMapping("/remove/{id}")
    public String removeAdmin(@PathVariable("id") Long id) {
        service.deleteById(id);
        String response = "removed admin with id=" + id;
        return response;
    }
    
    
}
