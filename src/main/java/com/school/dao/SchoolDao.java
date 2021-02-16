package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.School;

@Repository
public interface SchoolDao extends JpaRepository<School, Long> {

}
