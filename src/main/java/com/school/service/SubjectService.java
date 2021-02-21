package com.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.modal.Subject;

@Service
public interface SubjectService {

	Subject addSubject(Subject subject, long idSchool);
	
	Subject editSubject(Subject subject, long id);
	
	Subject findSubject(long id);
	
	Subject findSubjectForExam(long id);
	
	Subject findSubjectForCourse(long id);
	
	void deleteSubject(long id);
	
	List<Subject> findAllSubjectsForSchool(long id);
	
	List<Subject> findSubjectsForSchool(long id);
	
}
