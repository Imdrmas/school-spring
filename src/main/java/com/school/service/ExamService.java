package com.school.service;

import org.springframework.stereotype.Service;

import com.school.modal.Exam;

@Service
public interface ExamService {

	Exam addExam(Exam exam, long id);
	
	Exam editExam(Exam exam, long id);
	
	Exam findExam(long id);
	
	void DeleteExam(long id);
}
