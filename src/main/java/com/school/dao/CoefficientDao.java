package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Coefficient;

@Repository
public interface CoefficientDao extends JpaRepository<Coefficient, Long>{

}
