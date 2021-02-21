package com.school.modal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "programs")
public class Program extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	@JsonBackReference(value = "subject")
	@ManyToOne
	private Subject subject;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
	private List<Coefficient> coefficients;

	public Program() {
		super();
	}

	public Program(String name, Subject subject, List<Coefficient> coefficients) {
		super();
		this.name = name;
		this.subject = subject;
		this.coefficients = coefficients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<Coefficient> getCoefficients() {
		return coefficients;
	}

	public void setCoefficients(List<Coefficient> coefficients) {
		this.coefficients = coefficients;
	}

	public void addCoefficient(Coefficient coefficient) {
		if (getCoefficients() == null) {
			this.coefficients = new ArrayList<>();
		}
		getCoefficients().add(null);
		coefficient.setProgram(this);
	}

}
