package com.school.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.SubjectDao;
import com.school.dao.ProgramDao;
import com.school.modal.Subject;
import com.school.modal.Program;
import com.school.service.ProgramService;

@Component
@Transactional
public class ProgramServiceImpl implements ProgramService {
	
	@Autowired
	private ProgramDao programDao;
	
	@Autowired
	private SubjectDao matterDao;

	@Override
	public Program addProgram(Program program, long id) {
		Subject matter = matterDao.findById(id).get();
		program.setCreatedAt(new Date());
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
		return programDao.findById(id).get();
	}

	@Override
	public void deleteProgram(long id) {
        programDao.deleteById(id);
	}
	
	

}
