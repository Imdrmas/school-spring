package com.school.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.school.dao.ManagerDao;
import com.school.dao.SchoolDao;
import com.school.modal.Manager;
import com.school.modal.School;
import com.school.service.ManagerService;

@Component
@Transactional
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	private ManagerDao managerDao;
	
	@Autowired
	private SchoolDao schoolDao;

	@Override
	public Manager addManager(Manager manager, long id) {
		School school = schoolDao.findById(id).get();
		manager.setSchool(school);
		school.setManager(manager);
		return managerDao.save(manager);
	}

	@Override
	public Manager editManager(Manager manager, long id) {
		Manager existManager = managerDao.findById(id).get();
		existManager.setFirstName(manager.getFirstName());
		existManager.setLastName(manager.getLastName());
		return managerDao.save(existManager);
	}

	@Override
	public Manager findManager(long id) {
		return managerDao.findById(id).get();
	}

	@Override
	public void deleteManager(long id, long idSchhol) {
	   School school = schoolDao.findById(idSchhol).get();
	   school.setManager(null);
       managerDao.deleteById(id);	
	}

	@Override
	public Manager findManagerForSchool(long id) {
		School school = schoolDao.findById(id).get();
		return school.getManager();
	}

}
