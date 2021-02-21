package com.school.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.MatterDao;
import com.school.dao.SchoolDao;
import com.school.modal.Matter;
import com.school.modal.School;
import com.school.service.MatterService;

@Component
@Transactional
public class MatterServiceImpl implements MatterService {
	
	@Autowired
	private MatterDao matterDao;
	
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public Matter addMatter(Matter matter, long id) {
		School school = schoolDao.findById(id).get();
		school.addMatter(matter);
		return matterDao.save(matter);
	}

	@Override
	public Matter editMatter(Matter matter, long id) {
		Matter existMatter = matterDao.findById(id).get();
		existMatter.setName(matter.getName());
		existMatter.setColor(matter.getColor());
		existMatter.setDescription(matter.getDescription());
		return matterDao.save(existMatter);
	}

	@Override
	public Matter findMatter(long id) {
		return matterDao.findById(id).get();
	}

	@Override
	public void deleteMatter(long id) {
		matterDao.deleteById(id);
	}

}
