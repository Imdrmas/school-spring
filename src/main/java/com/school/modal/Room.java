package com.school.modal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "rooms")
public class Room extends PersistableElement {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String code;

	private int capacity;

	@JsonBackReference(value = "school")
	@ManyToOne
	private School school;
	
	@JsonBackReference(value = "level")
	@OneToOne(cascade = CascadeType.ALL)
	private Level level;

	public Room() {
		super();
	}

	public Room(String code, int capacity, School school, Level level) {
		super();
		this.code = code;
		this.capacity = capacity;
		this.school = school;
		this.level = level;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}  

	
}
