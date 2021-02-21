package com.school.service;

import org.springframework.stereotype.Service;

import com.school.modal.Course;

@Service
public interface CourseService {

	Course addCourse(Course course, long idLevel, long idSubject);
	
	Course editCourse(Course course, long idCourse, long idSubject);
	
	Course findCourse(long id);
	
	void deleteCourse(long idCourse, long idSubject);
}
