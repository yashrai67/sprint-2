package org.cap.apps.freelancerapp.freelancerms.controller;

import org.cap.apps.freelancerapp.freelancerms.dto.CreateFreelancerRequest;
import org.cap.apps.freelancerapp.freelancerms.dto.FreelancerDetails;
import org.cap.apps.freelancerapp.freelancerms.dto.UpdateFreelancerRequest;
import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.freelancerms.service.IFreelancerService;
import org.cap.apps.freelancerapp.util.FreelancerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequestMapping("/freelancers")
@RestController
public class FreelancerController {

    @Autowired
    private IFreelancerService service;

    @Autowired
    private FreelancerUtil freelancerUtil;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public FreelancerDetails addFreelancer(@RequestBody @Valid CreateFreelancerRequest requestData) {
        Freelancer freelancer = new Freelancer(requestData.getFirstname(), requestData.getLastname(),
                requestData.getPassword());
        freelancer = service.save(freelancer);
        FreelancerDetails details = freelancerUtil.toDetails(freelancer);
        return details;
    }

    @PutMapping("/update")
    public FreelancerDetails updateFreelancer(@RequestBody @Valid UpdateFreelancerRequest requestData) {
        Freelancer freelancer = new Freelancer(requestData.getFirstname(), requestData.getLastname(),
                requestData.getPassword());
        freelancer.setId(requestData.getId());
        freelancer = service.update(freelancer);
        FreelancerDetails details = freelancerUtil.toDetails(freelancer);
        return details;
    }

    @GetMapping("/get/{id}")
    public FreelancerDetails fetchFreelancer(@PathVariable("id") Long id) {
        Freelancer freelancer = service.findById(id);
        FreelancerDetails details = freelancerUtil.toDetails(freelancer);
        return details;
    }

    @DeleteMapping("/remove/{id}")
    public String removeFreelancer(@PathVariable("id") Long id) {
        service.deleteById(id);
        String response = "removed freelancer with id=" + id;
        return response;
    }

}