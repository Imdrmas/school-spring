package com.school.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.SchoolDao;
import com.school.dao.SchoolingDao;
import com.school.modal.School;
import com.school.modal.Schooling;
import com.school.service.SchoolingService;

@Component
@Transactional
public class SchoolingServiceImpl implements SchoolingService {
	
	@Autowired
	private SchoolingDao schoolingDao;
	
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public Schooling addSchooling(Schooling schooling, long id) {
		School school = schoolDao.findById(id).get();
		school.addSchooling(schooling);
		schooling.setCreatedAt(new Date());
		return schoolingDao.save(schooling);
	}

	@Override
	public Schooling editSchooling(Schooling schooling, long id) {
		Schooling existSchooling = schoolingDao.findById(id).get();
		existSchooling.setYear(schooling.getYear());
		existSchooling.setDescription(schooling.getDescription());
		return schoolingDao.save(existSchooling);
	}

	@Override
	public Schooling findSchooling(long id) {
		return schoolingDao.findById(id).get();
	}

	@Override
	public void deleteSchooling(long id) {
		schoolingDao.deleteById(id);		
	}

	@Override
	public List<Schooling> findSchoolingsForSchool(long id) {
		School school = schoolDao.findById(id).get();
		return school.getSchoolings();
	}

}
