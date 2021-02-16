package com.school.service;

import org.springframework.stereotype.Service;

import com.school.modal.Activity;

@Service
public interface ActivityService {
	
	Activity addActivity(Activity activity, long id);
	
	Activity editActivity(Activity activity, long id);
	
	Activity findActivity(long id);
	
	void deleteActivity(long id);

}
