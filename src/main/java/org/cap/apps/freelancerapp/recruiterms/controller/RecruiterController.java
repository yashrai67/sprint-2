package org.cap.apps.freelancerapp.recruiterms.controller;

import org.cap.apps.freelancerapp.recruiterms.dto.CreateRecruiterRequest;
import org.cap.apps.freelancerapp.recruiterms.dto.RecruiterDetails;
import org.cap.apps.freelancerapp.recruiterms.dto.UpdateRecruiterRequest;
import org.cap.apps.freelancerapp.recruiterms.entities.Recruiter;
import org.cap.apps.freelancerapp.recruiterms.service.IRecruiterService;
import org.cap.apps.freelancerapp.util.RecruitertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Validated
@RequestMapping("/recruiters")
@RestController
public class RecruiterController {
	@Autowired
	private IRecruiterService service;

	@Autowired
	private RecruitertUtil recruiterUtil;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public RecruiterDetails add(@RequestBody @Valid CreateRecruiterRequest requestData) {
		Recruiter recruiter = new Recruiter(requestData.getFirstname(), requestData.getLastname(),
				requestData.getPassword());
		recruiter = service.save(recruiter);
		RecruiterDetails details = recruiterUtil.toDetails(recruiter);
		return details;
	}

	@PutMapping("/update")
	public RecruiterDetails update(@RequestBody @Valid UpdateRecruiterRequest requestData) {
		Recruiter recruiter =new Recruiter(requestData.getFirstname(), requestData.getLastname(),
				requestData.getPassword());
		recruiter.setId(requestData.getId());
		recruiter = service.update(recruiter);
		RecruiterDetails details = recruiterUtil.toDetails(recruiter);
		return details;
	}

	@GetMapping("/get/{id}")
	public RecruiterDetails fetchStudent(@PathVariable("id") Long id) {
		Recruiter recruiter = service.findById(id);
		RecruiterDetails details = recruiterUtil.toDetails(recruiter);
		return details;
	}

	@DeleteMapping("/remove/{id}")
	public String removeRecruiter(@PathVariable("id") Long id) {
		service.deleteById(id);
		String response = "removed recruiter with id=" + id;
		return response;
	}

}
