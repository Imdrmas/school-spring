package com.school.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.ExamDao;
import com.school.dao.SchoolDao;
import com.school.modal.Exam;
import com.school.modal.School;
import com.school.service.ExamService;

@Component
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDao examDao;
	
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public Exam addExam(Exam exam, long id) {
		School school = schoolDao.findById(id).get();
		school.addExam(exam);
		return examDao.save(exam);
	}

	@Override
	public Exam editExam(Exam exam, long id) {
		Exam existExam = examDao.findById(id).get();
		existExam.setDay(exam.getDay());
		existExam.setStart(exam.getStart());
		existExam.setEnd(exam.getEnd());
		return examDao.save(existExam);
	}

	@Override
	public Exam findExam(long id) {
		return examDao.findById(id).get();
	}

	@Override
	public void DeleteExam(long id) {
		examDao.deleteById(id);
	}
}
