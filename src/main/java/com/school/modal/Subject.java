package com.school.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "subjects")
public class Subject extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String color;

	@JsonBackReference(value = "school")
	@ManyToOne
	private School school;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
	private List<Program> programs;
	
	@JsonBackReference(value = "exam")
	@OneToOne
	private Exam exam;
	
	@JsonBackReference(value = "course")
	@OneToOne
	private Course course;
	

	public Subject() {
		super();
	}

	public Subject(String name, String color, 
			School school, List<Program> programs, Exam exam, Course course) {
		super();
		this.name = name;
		this.color = color;
		this.school = school;
		this.programs = programs;
		this.exam = exam;
		this.course = course;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public void addProgram(Program program) {
		if (getPrograms() == null) {
			this.programs = new ArrayList<>();
		}
		getPrograms().add(program);
		program.setSubject(this);
	}

}
