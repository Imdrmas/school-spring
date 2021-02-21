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

import com.school.modal.Subject;
import com.school.service.SubjectService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/addSubject/{id}")
	Subject addSubject(@RequestBody Subject subject, @PathVariable long id) {
		return subjectService.addSubject(subject, id);
	}
	
	@PutMapping("/editSubject/{id}")
	Subject editSubject(@RequestBody Subject subject, @PathVariable long id) {
		return subjectService.editSubject(subject, id);
	}
	
	@GetMapping("/findSubject/{id}")
	Subject findSubject(@PathVariable long id) {
		return subjectService.findSubject(id);
	}
	
	@GetMapping("/findSubjectForExam/{id}")
	Subject findSubjectForExam(@PathVariable long id) {
		return subjectService.findSubjectForExam(id);
	}
	
	@DeleteMapping("/deleteSubject/{id}")
	void deleteSubject(@PathVariable long id) {
		subjectService.deleteSubject(id);
	}
	@GetMapping("/findAllSubjectsForSchool/{id}")
	List<Subject> findAllSubjectsForSchool(@PathVariable long id) {
		return subjectService.findAllSubjectsForSchool(id);
	}
	
	@GetMapping("/findSubjectForCourse/{id}")
	Subject findSubjectForCourse(@PathVariable long id) {
		return subjectService.findSubjectForCourse(id);
	}
	
	@GetMapping("/findSubjectsForSchool/{id}")
	List<Subject> findSubjectsForSchool(@PathVariable long id) {
		return subjectService.findSubjectsForSchool(id);
	}

}
