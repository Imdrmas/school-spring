package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Matter;

@Repository
public interface MatterDao extends JpaRepository<Matter, Long> {

}
