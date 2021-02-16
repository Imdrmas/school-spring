package com.school.service;

import org.springframework.stereotype.Service;

import com.school.modal.Matter;

@Service
public interface MatterService {

	Matter addMatter(Matter matter, long id);
	
	Matter editMatter(Matter matter, long id);
	
	Matter findMatter(long id);
	
	void deleteMatter(long id);
}
