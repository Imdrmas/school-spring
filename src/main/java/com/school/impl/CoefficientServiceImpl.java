package com.school.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.CoefficientDao;
import com.school.dao.ProgramDao;
import com.school.modal.Coefficient;
import com.school.modal.Program;
import com.school.service.CoefficientService;

@Component
@Transactional
public class CoefficientServiceImpl implements CoefficientService {
	
	@Autowired
	private CoefficientDao coefficientDao;
	
	@Autowired
	private ProgramDao programDao;

	@Override
	public Coefficient addCoefficient(Coefficient coefficient, long id) {
		Program program = programDao.findById(id).get();
		coefficient.setCreatedAt(new Date());
	     program.addCoefficient(coefficient);
		return coefficientDao.save(coefficient);
	}

	@Override
	public Coefficient editCoefficient(Coefficient coefficient, long id) {
		Coefficient existCoefficient = coefficientDao.findById(id).get();
		existCoefficient.setGrade(coefficient.getGrade());
		existCoefficient.setDescription(coefficient.getDescription());
		return coefficientDao.save(existCoefficient);
	}

	@Override
	public Coefficient findCoefficient(long id) {
		return coefficientDao.findById(id).get();
	}

	@Override
	public void deleteCoefficient(long id) {
		coefficientDao.deleteById(id);		
	}
	
	

}
