package org.cap.apps.freelancerapp.skillms.controller;

import org.cap.apps.freelancerapp.skillms.dto.CreateSkillRequest;
import org.cap.apps.freelancerapp.skillms.dto.SkillDetails;
import org.cap.apps.freelancerapp.skillms.entities.Skill;
import org.cap.apps.freelancerapp.skillms.service.ISkillService;
import org.cap.apps.freelancerapp.skillms.util.SkillUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/skills")
@RestController
public class SkillController {
	
	@Autowired
	private ISkillService skillService;
	
	@Autowired
	private SkillUtil skillUtil;
	
	@ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
	public SkillDetails add(@RequestBody CreateSkillRequest requestData) {
		Skill skill=new Skill();
		skill.setDescription(requestData.getDescription());
		skill.setName(requestData.getName());
		skill=skillService.save(skill);
		SkillDetails details=skillUtil.toDetails(skill);
		return details;
	}
	
	 @GetMapping("/by/id/{id}")
	 public SkillDetails findSkill(@PathVariable("id") Long id) {
		 Skill skill=skillService.findById(id);
			SkillDetails details=skillUtil.toDetails(skill);
			return details;
	 }

}
