package com.school.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "schoolings")
public class Schooling {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String year;

	@JsonBackReference(value = "school")
	@ManyToOne
	private School school;

	public Schooling() {
		super();
	}

	public Schooling(String year, School school) {
		super();
		this.year = year;
		this.school = school;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
