package com.school.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.SchoolDao;
import com.school.modal.School;
import com.school.service.SchoolService;

@Component
@Transactional
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public School addSchool(School school) {
		school.setCreatedAt(new Date());
		return schoolDao.save(school);
	}

	@Override
	public School editSchool(School school, long id) {
		School existSchool = schoolDao.findById(id).get();
		existSchool.setName(school.getName());
		existSchool.setCity(school.getCity());
		existSchool.setDescription(school.getDescription());
		existSchool.setOpen(school.getOpen());
		existSchool.setClose(school.getClose());
		return schoolDao.save(existSchool);
	}

	@Override
	public School findSchool(long id) {
		return schoolDao.findById(id).get();
	}

	@Override
	public void deleteSchool(long id) {
		schoolDao.deleteById(id);
	}

	@Override
	public List<School> findSchools() {
		return schoolDao.findAll();
	}

}
