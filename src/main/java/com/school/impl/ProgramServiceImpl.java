package com.school.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.MatterDao;
import com.school.dao.ProgramDao;
import com.school.modal.Matter;
import com.school.modal.Program;
import com.school.service.ProgramService;

@Component
@Transactional
public class ProgramServiceImpl implements ProgramService {
	
	@Autowired
	private ProgramDao programDao;
	
	@Autowired
	private MatterDao matterDao;

	@Override
	public Program addProgram(Program program, long id) {
		Matter matter = matterDao.findById(id).get();
		matter.addProgram(program);
		return programDao.save(program);
	}

	@Override
	public Program editProgram(Program program, long id) {
	   Program existProgram = programDao.findById(id).get();
	   existProgram.setName(program.getName());
	   existProgram.setDescription(program.getDescription());
		return null;
	}

	@Override
	public Program findProgram(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProgram(long id) {
		// TODO Auto-generated method stub
		
	}
	
	

}
