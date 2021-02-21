package com.school.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.LevelDao;
import com.school.dao.RoomDao;
import com.school.dao.SchoolDao;
import com.school.modal.Level;
import com.school.modal.Room;
import com.school.modal.School;
import com.school.service.RoomService;

@Component
@Transactional
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private SchoolDao schoolDao;
	
	@Override
	public Room addRoom(Room room, long id) {
		School school = schoolDao.findById(id).get();
		room.setCreatedAt(new Date());
		school.addRoom(room);
		return roomDao.save(room);
	}

	@Override
	public Room editRoom(Room room, long id) {
		Room existRoom = roomDao.findById(id).get();
		existRoom.setCode(room.getCode());
		existRoom.setCapacity(room.getCapacity());
		existRoom.setDescription(room.getDescription());
		return roomDao.save(existRoom);
	}

	@Override
	public Room findRoom(long id) {
		return roomDao.findById(id).get();
	}

	@Override
	public void deleteRoom(long id) {
		roomDao.deleteById(id);
	}

	@Override
	public List<Room> findRoomsForSchool(long id) {
		School school = schoolDao.findById(id).get();
		return school.getRooms();
	}

}
