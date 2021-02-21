package com.school.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.LevelDao;
import com.school.dao.RoomDao;
import com.school.dao.SchoolingDao;
import com.school.modal.Level;
import com.school.modal.Room;
import com.school.modal.Schooling;
import com.school.service.LevelService;

@Component
@Transactional
public class LevelServiceImpl implements LevelService {
	
	@Autowired
	private LevelDao levelDao;
	
	@Autowired
	private SchoolingDao schoolingDao;
	
	@Autowired
	private RoomDao roomDao;

	@Override
	public Level addLevel(Level level, long id) {
		Schooling schooling = schoolingDao.findById(id).get();
		level.setCreatedAt(new Date());
		schooling.addLevel(level);
		return levelDao.save(level);
	}

	@Override
	public Level editLevel(Level level, long id) {
		Level existLevel = levelDao.findById(id).get();
		existLevel.setLabel(level.getLabel());
		existLevel.setDescription(level.getDescription());
		return levelDao.save(existLevel);
	}

	@Override
	public Level findLevel(long id) {
		return levelDao.findById(id).get();
	}

	@Override
	public void deleteLevel(long id) {
		levelDao.deleteById(id);	
	}

	@Override
	public void addLevelToRoom(long idRoom, long idLevel) {
		Level existLevel = levelDao.findById(idLevel).get();
		Room room = roomDao.findById(idRoom).get();
		existLevel.setRoom(room);
		room.setLevel(existLevel);
	}


	@Override
	public List<Level> findLevels() {
		return levelDao.findAll();
	}

	@Override
	public void deleteLevelFromRoom(long idRoom, long idLevel) {
		Level existLevel = levelDao.findById(idLevel).get();
		Room room = roomDao.findById(idRoom).get();
		existLevel.setRoom(null);
		room.setLevel(null);
	}

	@Override
	public Level findLevelForRoom(long idRoom) {
		Room room = roomDao.findById(idRoom).get();
		return room.getLevel();
	}
	
	

}
