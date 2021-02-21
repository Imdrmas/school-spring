package com.school.service;

import java.util.List;

import com.school.modal.Level;

public interface LevelService {
	
	Level addLevel(Level level, long id);
	
	Level editLevel(Level level, long id);
	
	Level findLevel(long id);
	
	Level findLevelForRoom(long id);
	
	void deleteLevel(long id);
	
	void addLevelToRoom(long idRoom, long idLevel);
	
	List<Level> findLevels();
	
	void deleteLevelFromRoom(long idRoom, long idLevel);
	

}
