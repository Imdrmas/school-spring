package com.school.service;

import org.springframework.stereotype.Service;

import com.school.modal.Manager;

@Service
public interface ManagerService {

	Manager addManager(Manager manager, long id);
	
	Manager editManager(Manager manager, long id);
	
	Manager findManager(long id);
	
	Manager findManagerForSchool(long id);
	
	void deleteManager(long id, long idSchhol);
}
