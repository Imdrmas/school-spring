package com.school.controller;

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

import com.school.modal.Manager;
import com.school.service.ManagerService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ManagerConntroller {

	@Autowired
	private ManagerService managerService;

	@PostMapping("/addManager/{id}")
	Manager addManager(@RequestBody Manager manager, @PathVariable long id) {
		return managerService.addManager(manager, id);
	}

	@PutMapping("/editManager/{id}")
	Manager editManager(@RequestBody Manager manager, @PathVariable long id) {
		return managerService.editManager(manager, id);
	}

	@GetMapping("/findManager/{id}")
	Manager findManager(@PathVariable long id) {
		return managerService.findManager(id);
	}
	
	@GetMapping("/findManagerForSchool/{id}")
	Manager findManagerForSchool(@PathVariable long id) {
		return managerService.findManagerForSchool(id);
	}

	@DeleteMapping("/deleteManager/{id}/{idSchhol}")
	void deleteManager(@PathVariable long id, @PathVariable long idSchhol) {
		managerService.deleteManager(id, idSchhol);
	}

}
