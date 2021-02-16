package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Program;

@Repository
public interface ProgramDao extends JpaRepository<Program, Long>{

}
