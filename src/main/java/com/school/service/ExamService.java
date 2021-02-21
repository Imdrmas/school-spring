package com.school.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.school.modal.Exam;

@Service
public interface ExamService {

	Exam addExam(Exam exam, long idSchool, long  idSubject);
	
	Exam editExam(Exam exam, long id);
	
	Exam findExam(long id);
	
	void deleteExam(long id, long idSubject);
	
	List<Exam> findExamsForSchool(long id);

}
