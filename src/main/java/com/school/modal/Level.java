package com.school.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "levels")
public class Level extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true)
	private String label;
	
	@JsonBackReference(value = "schooling")
	@ManyToOne
	private Schooling schooling;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "level")
	private List<Course> courses;
	
	@JsonBackReference(value = "room")
	@OneToOne
	private Room room;

	public Level() {
		super();
	}

	public Level(String label, Schooling schooling, List<Course> courses, Room room) {
		super();
		this.label = label;
		this.schooling = schooling;
		this.courses = courses;
		this.room = room;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Schooling getSchooling() {
		return schooling;
	}

	public void setSchooling(Schooling schooling) {
		this.schooling = schooling;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public void addCourse(Course course) {
		if (getCourses()==null) {
			this.courses = new ArrayList<>();
		}
		getCourses().add(course);
		course.setLevel(this);
	}

}
