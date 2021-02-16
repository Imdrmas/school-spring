package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Manager;

@Repository
public interface ManagerDao extends JpaRepository<Manager, Long>{

}
