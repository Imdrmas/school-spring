package com.school.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.dao.ActivityDao;
import com.school.dao.SchoolDao;
import com.school.modal.Activity;
import com.school.modal.School;
import com.school.service.ActivityService;

@Component
@Transactional
public class ActivityServiceImpl implements ActivityService {
	
	@Autowired
	private ActivityDao activityDao;
	
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public Activity addActivity(Activity activity, long id) {
		School school = schoolDao.findById(id).get();
		school.addActivity(activity);
		return activityDao.save(activity);
	}

	@Override
	public Activity editActivity(Activity activity, long id) {
		Activity existActivity = activityDao.findById(id).get();
		existActivity.setType(activity.getType());
		existActivity.setDay(activity.getDay());
		existActivity.setDescription(activity.getDescription());
		return activityDao.save(existActivity);
	}

	@Override
	public Activity findActivity(long id) {
		return activityDao.findById(id).get();
	}

	@Override
	public void deleteActivity(long id) {
		 activityDao.deleteById(id);
	}

}
