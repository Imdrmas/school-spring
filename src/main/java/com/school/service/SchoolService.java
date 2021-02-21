package com.school.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.school.modal.School;

@Service
public interface SchoolService {
	
	School addSchool(School school);
	
	School editSchool(School school, long id);
	
	School findSchool(long id);
	
	void deleteSchool(long id);
	
	List<School> findSchools();

}
