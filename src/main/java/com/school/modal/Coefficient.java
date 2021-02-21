package com.school.modal;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "coefficients")
public class Coefficient extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int grade;

	@JsonBackReference(value = "program")
	@ManyToOne
	private Program program;

	public Coefficient() {
		super();
	}

	public Coefficient(int grade, Program program) {
		super();
		this.grade = grade;
		this.program = program;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}    
   
}
