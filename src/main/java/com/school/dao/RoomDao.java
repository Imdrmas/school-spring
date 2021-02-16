package com.school.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.modal.Room;

@Repository
public interface RoomDao extends JpaRepository<Room, Long> {

}
