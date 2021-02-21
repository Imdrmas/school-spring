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
import com.school.modal.Program;
import com.school.service.ProgramService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProgramController {
	
	@Autowired
	private ProgramService programService;
	
	@PostMapping("/addProgram/{id}")
	Program addProgram(@RequestBody Program program, @PathVariable long id) {
		return programService.addProgram(program, id);
	}
	
	@PutMapping("/editProgram/{id}")
	Program editProgram(@RequestBody Program program, @PathVariable long id) {
		return programService.editProgram(program, id);
	}
	
	@GetMapping("/findProgram/{id}")
	Program findProgram(@PathVariable long id) {
		return programService.findProgram(id);
	}
	
	@DeleteMapping("/deleteProgram/{id}")
	void deleteProgram(@PathVariable long id) {
		programService.deleteProgram(id);
	}

}
