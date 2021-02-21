package com.school.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.SubjectDao;
import com.school.dao.CourseDao;
import com.school.dao.ExamDao;
import com.school.dao.SchoolDao;
import com.school.modal.Subject;
import com.school.modal.Course;
import com.school.modal.Exam;
import com.school.modal.School;
import com.school.service.SubjectService;

@Component
@Transactional
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Autowired
	private ExamDao examDao;
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public Subject addSubject(Subject subject, long idSchool) {
		School school = schoolDao.findById(idSchool).get();
		subject.setCreatedAt(new Date());
		school.addSubject(subject);
		return subjectDao.save(subject);
	}

	@Override
	public Subject editSubject(Subject subject, long id) {
		Subject existSubject = subjectDao.findById(id).get();
		existSubject.setName(subject.getName());
		existSubject.setColor(subject.getColor());
		existSubject.setDescription(subject.getDescription());
		return subjectDao.save(existSubject);
	}

	@Override
	public Subject findSubject(long id) {
		return subjectDao.findById(id).get();
	}

	@Override
	public void deleteSubject(long id) {
		subjectDao.deleteById(id);
	}

	@Override
	public List<Subject> findAllSubjectsForSchool(long id) {
		School school = schoolDao.findById(id).get();
		return school.getSubjects();
	}

	@Override
	public Subject findSubjectForExam(long id) {
		Exam exam = examDao.findById(id).get();
		return exam.getSubject();
	}

	@Override
	public Subject findSubjectForCourse(long id) {
		Course course = courseDao.findById(id).get();
		return course.getSubject();
	}

	@Override
	public List<Subject> findSubjectsForSchool(long id) {
		School school = schoolDao.findById(id).get();
		return school.getSubjects();
	}


}
