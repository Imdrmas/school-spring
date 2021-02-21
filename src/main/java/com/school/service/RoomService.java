package com.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.modal.Room;

@Service
public interface RoomService {
	
	Room addRoom(Room room, long id);
	
	Room editRoom(Room room, long id);
	
	Room findRoom(long id);
	
	void deleteRoom(long id);
	
	List<Room> findRoomsForSchool(long id);

}
