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

import com.school.modal.Exam;
import com.school.service.ExamService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ExamController {

	@Autowired
	private ExamService examService;

	@PostMapping("/addExam/{idSchool}/{idSubject}")
	Exam addExam(@RequestBody Exam exam, @PathVariable long idSchool, @PathVariable long  idSubject) {
		return examService.addExam(exam, idSchool, idSubject);
	}

	@PutMapping("/editExam/{id}")
	Exam editExam(@RequestBody Exam exam, @PathVariable long id) {
		return examService.editExam(exam, id);
	}

	@GetMapping("/findExam/{id}")
	Exam findExam(@PathVariable long id) {
		return examService.findExam(id);
	}

	@DeleteMapping("/deleteExam/{id}/{idSubject}")
	void deleteExam(@PathVariable long id, @PathVariable long idSubject) {
		examService.deleteExam(id, idSubject);
	}
	
	@GetMapping("/findExamsForSchool/{id}")
	List<Exam> findExamsForSchool(@PathVariable long id) {
		return examService.findExamsForSchool(id);
	}

}
