package com.school.service;

import org.springframework.stereotype.Service;

import com.school.modal.Program;

@Service
public interface ProgramService {

	Program addProgram(Program program, long id);
	
	Program editProgram(Program program, long id);
	
	Program findProgram(long id);
	
	void deleteProgram(long id);
	
}
