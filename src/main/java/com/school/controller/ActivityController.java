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

import com.school.modal.Activity;
import com.school.service.ActivityService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ActivityController {

	@Autowired
	private ActivityService activityService;

	@PostMapping("/addActivity/{id}")
	Activity addActivity(@RequestBody Activity activity, @PathVariable long id) {
		return activityService.addActivity(activity, id);
	}

	@PutMapping("/editActivity/{id}")
	Activity editActivity(@RequestBody Activity activity, @PathVariable long id) {
		return activityService.editActivity(activity, id);
	}

	@GetMapping("/findActivity/{id}")
	Activity findActivity(@PathVariable long id) {
		return activityService.findActivity(id);
	}

	@DeleteMapping("/deleteActivity/{id}")
	void deleteActivity(@PathVariable long id) {
		activityService.deleteActivity(id);
	}
	@GetMapping("/findActivitiesForSchool/{id}")
	List<Activity> findActivitiesForSchool(@PathVariable long id) {
		return activityService.findActivitiesForSchool(id);
	}

}
