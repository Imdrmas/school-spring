package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long>{

}
