package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Activity;

@Repository
public interface ActivityDao extends JpaRepository<Activity, Long>{

}
