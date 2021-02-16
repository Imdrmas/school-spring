package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Schooling;

@Repository
public interface SchoolingDao extends JpaRepository<Schooling, Long>{

}
