package com.school.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.modal.Level;
import com.school.service.LevelService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class LevelController {
	
	@Autowired
	private LevelService levelService;
	
	@PostMapping("/addLevel/{id}")
	Level addLevel(@RequestBody Level level, @PathVariable long id) {
		return levelService.addLevel(level, id);
	}
	@PutMapping("/editLevel/{id}")
	Level editLevel(@RequestBody Level level, @PathVariable long id) {
		return levelService.editLevel(level, id);
	}
	
	@GetMapping("/findLevel/{id}")
	Level findLevel(@PathVariable long id) {
		return levelService.findLevel(id);
	}
	@DeleteMapping("/deleteLevel/{id}")
	void deleteLevel(@PathVariable long id) {
		levelService.deleteLevel(id);
	}
	@PostMapping("/addLevelToRoom/{idRoom}/{idLevel}")
	void addLevelToRoom(@PathVariable long idRoom, @PathVariable long idLevel) {
		levelService.addLevelToRoom(idRoom, idLevel);
	}
	
	@GetMapping("/findLevels")
	List<Level> findLevels() {
		return levelService.findLevels();
	}
	@DeleteMapping("/deleteLevelFromRoom/{idRoom}/{idLevel}")
	void deleteLevelFromRoom(@PathVariable long idRoom, @PathVariable long idLevel)  {
	    levelService.deleteLevelFromRoom(idRoom, idLevel);
	}
	@GetMapping("/findLevelForRoom/{idRoom}")
	Level findLevelForRoom(@PathVariable long idRoom) {
		return levelService.findLevelForRoom(idRoom);
	}
}
