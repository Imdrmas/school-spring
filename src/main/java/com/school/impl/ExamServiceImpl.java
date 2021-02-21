package com.school.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.ExamDao;
import com.school.dao.SubjectDao;
import com.school.dao.SchoolDao;
import com.school.modal.Exam;
import com.school.modal.Subject;
import com.school.modal.School;
import com.school.service.ExamService;

@Component
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao examDao;
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	private SubjectDao subjectDao;

	@Override
	public Exam addExam(Exam exam, long idSchool, long idSubject) {
		School school = schoolDao.findById(idSchool).get();
		Subject subject = subjectDao.findById(idSubject).get();
		exam.setCreatedAt(new Date());
		school.addExam(exam);
		exam.setSubject(subject);
		subject.setExam(exam);
		return examDao.save(exam);
	}

	@Override
	public Exam editExam(Exam exam, long id) {
		Exam existExam = examDao.findById(id).get();
		existExam.setDate(exam.getDate());
		existExam.setDescription(exam.getDescription());
		existExam.setStart(exam.getStart());
		existExam.setEnd(exam.getEnd());
		return examDao.save(existExam);
	}

	@Override
	public Exam findExam(long id) {
		return examDao.findById(id).get();
	}

	@Override
	public void deleteExam(long id, long idSubject) {
		Exam existExam = examDao.findById(id).get();
		Subject subject = subjectDao.findById(idSubject).get();
		existExam.setSubject(null);
		subject.setExam(null);
		examDao.delete(existExam);
	}

	@Override
	public List<Exam> findExamsForSchool(long id) {
		School school = schoolDao.findById(id).get();
		return school.getExams();
	}

}
