package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Level;

@Repository
public interface LevelDao extends JpaRepository<Level, Long>{

}
