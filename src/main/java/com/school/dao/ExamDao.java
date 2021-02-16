package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Exam;

@Repository
public interface ExamDao extends JpaRepository<Exam, Long> {

}
