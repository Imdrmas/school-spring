package com.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.modal.Schooling;

@Service
public interface SchoolingService {
	
	Schooling addSchooling(Schooling schooling, long id);
	
	Schooling editSchooling(Schooling schooling, long id);
	
	Schooling findSchooling(long id);
	
	void deleteSchooling(long id);
	
	List<Schooling> findSchoolingsForSchool(long id);

}
