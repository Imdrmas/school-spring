package com.school.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.school.dao.CoefficientDao;
import com.school.dao.MatterDao;
import com.school.modal.Coefficient;
import com.school.modal.Matter;
import com.school.service.CoefficientService;

@Component
@Transactional
public class CoefficientServiceImpl implements CoefficientService {
	
	@Autowired
	private CoefficientDao coefficientDao;
	
	@Autowired
	private MatterDao matterDao;

	@Override
	public Coefficient addCoefficient(Coefficient coefficient, long id) {
		Matter matter = matterDao.findById(id).get();
		matter.addCoefficient(coefficient);
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
