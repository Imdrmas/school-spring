package com.school.controller;

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

import com.school.modal.Course;
import com.school.service.CourseService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CourseController {
	
	@Autowired
	private CourseService courseService;

	@PostMapping("/addCourse/{idLevel}/{idSubject}")
	Course addCourse(@RequestBody Course course, @PathVariable long idLevel, @PathVariable long idSubject) {
		return courseService.addCourse(course, idLevel, idSubject);
	}
	
	@PutMapping("/editCourse/{idCourse}/{idSubject}")
	Course editCourse(@RequestBody Course course, @PathVariable long idCourse, @PathVariable long idSubject) {
		return courseService.editCourse(course, idCourse, idSubject);
	}
	
	@GetMapping("/findCourse/{id}")
	Course findCourse(@PathVariable long id) {
		return courseService.findCourse(id);
	}
	
	@DeleteMapping("/deleteCourse/{idCourse}/{idSubject}")
	void deleteCourse(@PathVariable long idCourse, @PathVariable long idSubject) {
		courseService.deleteCourse(idCourse, idSubject);
	}

}
