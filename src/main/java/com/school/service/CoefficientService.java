package com.school.service;

import org.springframework.stereotype.Service;

import com.school.modal.Coefficient;

@Service
public interface CoefficientService {
	
	Coefficient addCoefficient(Coefficient coefficient, long id);
	
	Coefficient editCoefficient(Coefficient coefficient, long id);
	
	Coefficient findCoefficient(long id);
	
	void deleteCoefficient(long id);

}
