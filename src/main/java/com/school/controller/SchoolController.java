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

import com.school.modal.School;
import com.school.service.SchoolService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	@PostMapping("/addSchool")
	School addSchool(@RequestBody School school) {
		return schoolService.addSchool(school);
	}

	@PutMapping("/editSchool/{id}")
	School editSchool(@RequestBody School school, @PathVariable long id) {
		return schoolService.editSchool(school, id);
	}

	@GetMapping("/findSchool/{id}")
	School findSchool(@PathVariable long id) {
		return schoolService.findSchool(id);
	}

	@DeleteMapping("/deleteSchool/{id}")
	void deleteSchool(@PathVariable long id) {
		schoolService.deleteSchool(id);
	}

	@GetMapping("/findSchools")
	List<School> findSchools() {
		return schoolService.findSchools();
	}

}
