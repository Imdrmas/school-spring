package com.school.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "activites")
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String type;

	private String day;

	@Column(columnDefinition = "TEXT")
	private String description;

	@JsonBackReference(value = "school")
	@ManyToOne
	private School school;

	public Activity() {
		super();
	}

	public Activity(String type, String day, String description, School school) {
		super();
		this.type = type;
		this.day = day;
		this.description = description;
		this.school = school;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
