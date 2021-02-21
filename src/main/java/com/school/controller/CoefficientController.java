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

import com.school.modal.Coefficient;
import com.school.service.CoefficientService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class CoefficientController {

	@Autowired
	private CoefficientService coefficientService;

	@PostMapping("/addCoefficient/{id}")
	Coefficient addCoefficient(@RequestBody Coefficient coefficient, @PathVariable long id) {
		return coefficientService.addCoefficient(coefficient, id);
	}

	@PutMapping("/editCoefficient/{id}")
	Coefficient editCoefficient(@RequestBody Coefficient coefficient, @PathVariable long id) {
		return coefficientService.editCoefficient(coefficient, id);
	}

	@GetMapping("/findCoefficient/{id}")
	Coefficient findCoefficient(@PathVariable long id) {
		return coefficientService.findCoefficient(id);
	}

	@DeleteMapping("/deleteCoefficient/{id}")
	void deleteCoefficient(@PathVariable long id) {
		coefficientService.deleteCoefficient(id);
	}

}
