package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.modal.Schooling;
import com.school.service.SchoolingService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class SchoolingController {

	@Autowired
	private SchoolingService schoolingService;

	@PostMapping("/addSchooling/{id}")
	Schooling addSchooling(@RequestBody Schooling schooling, @PathVariable long id) {
		return schoolingService.addSchooling(schooling, id);
	}

	@PutMapping("/editSchooling/{id}")
	Schooling editSchooling(@RequestBody Schooling schooling, @PathVariable long id) {
		return schoolingService.editSchooling(schooling, id);
	}

	@GetMapping("/findSchooling/{id}")
	Schooling findSchooling(@PathVariable long id) {
		return schoolingService.findSchooling(id);
	}

	@DeleteMapping("/deleteSchooling/{id}")
	void deleteSchooling(@PathVariable long id) {
		schoolingService.deleteSchooling(id);
	}
	@GetMapping("/findSchoolingsForSchool/{id}")
	List<Schooling> findSchoolingsForSchool(@PathVariable long id) {
		return schoolingService.findSchoolingsForSchool(id);
	}
}
