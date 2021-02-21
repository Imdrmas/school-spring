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

import com.school.modal.Room;
import com.school.service.RoomService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class RoomController {

	@Autowired
	private RoomService roomService;

	@PostMapping("/addRoom/{id}")
	Room addRoom(@RequestBody Room room, @PathVariable long id) {
		return roomService.addRoom(room, id);
	}

	@PutMapping("/editRoom/{id}")
	Room editRoom(@RequestBody Room room, @PathVariable long id) {
		return roomService.editRoom(room, id);
	}

	@GetMapping("/findRoom/{id}")
	Room findRoom(@PathVariable long id) {
		return roomService.findRoom(id);
	}

	@DeleteMapping("/deleteRoom/{id}")
	void deleteRoom(@PathVariable long id) {
		roomService.deleteRoom(id);
	}
	
	@GetMapping("/findRoomsForSchool/{id}")
	List<Room> findRoomsForSchool(@PathVariable long id) {
		return roomService.findRoomsForSchool(id);
	}
}
