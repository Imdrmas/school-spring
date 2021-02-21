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
@Table(name = "schoolings")
public class Schooling extends PersistableElement {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int year;

	@JsonBackReference(value = "school")
	@ManyToOne
	private School school;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "schooling")
	private List<Level> levels;

	public Schooling() {
		super();
	}

	public Schooling(int year, School school, List<Level> levels) {
		super();
		this.year = year;
		this.school = school;
		this.levels = levels;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
	
	public void addLevel(Level level) {
		if (getLevels()==null) {
			this.levels = new ArrayList<>();
		}
		getLevels().add(level);
		level.setSchooling(this);
	}

	
}
