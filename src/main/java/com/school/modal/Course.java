package com.school.modal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "courses")
public class Course extends PersistableElement {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String date;
	
	private String startDate;
	
	private String endDate;
	
	@JsonBackReference(value = "subject")
	@OneToOne(cascade = CascadeType.ALL)
	private Subject subject;
	
	@JsonBackReference(value = "level")
	@ManyToOne
	private Level level;

	public Course() {
		super();
	}

	public Course(String date, String startDate, String endDate, Subject subject, Level level) {
		super();
		this.date = date;
		this.startDate = startDate;
		this.endDate = endDate;
		this.subject = subject;
		this.level = level;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}	

}
