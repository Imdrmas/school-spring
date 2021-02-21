package com.school.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.CourseDao;
import com.school.dao.LevelDao;
import com.school.dao.SubjectDao;
import com.school.modal.Course;
import com.school.modal.Level;
import com.school.modal.Subject;
import com.school.service.CourseService;

@Component
@Transactional
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private LevelDao levelDao;
	
	@Autowired
	private SubjectDao subjectDao;

	@Override
	public Course addCourse(Course course, long idLevel, long idSubject) {
		Level level = levelDao.findById(idLevel).get();
		Subject subject = subjectDao.findById(idSubject).get();
		course.setCreatedAt(new Date());
		level.addCourse(course);
		course.setSubject(subject);
		subject.setCourse(course);
		return courseDao.save(course);
	}

	@Override
	public Course editCourse(Course course, long idCourse, long idSubject) {
		Subject subject = subjectDao.findById(idSubject).get();
		Course existsCourse = courseDao.findById(idCourse).get();
		existsCourse.setDate(course.getDate());
		existsCourse.setStartDate(course.getStartDate());
		existsCourse.setEndDate(course.getEndDate());
		existsCourse.setDescription(course.getDescription());
		subject.setCourse(existsCourse);
		existsCourse.setSubject(subject);
		return courseDao.save(existsCourse);
	}

	@Override
	public Course findCourse(long id) {
		return courseDao.findById(id).get();
	}

	@Override
	public void deleteCourse(long idCourse, long idSubject) {
		Subject subject = subjectDao.findById(idSubject).get();
		Course existsCourse = courseDao.findById(idCourse).get();
		subject.setCourse(null);
		existsCourse.setSubject(null);;;
		courseDao.delete(existsCourse);	
	}
	
}
