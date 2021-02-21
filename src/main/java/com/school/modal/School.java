package com.school.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "schools")
public class School extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private String city;

	private String department;

	private String open;

	private String close;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Activity> activities;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Schooling> schoolings;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Exam> exams;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Subject> subjects;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Room> rooms;

	@JsonBackReference(value = "manager")
	@OneToOne(cascade = CascadeType.ALL)
	private Manager manager;

	public School() {
		super();
	}

	public School(String name, String city, String department, String open, String close,
			List<Activity> activities, List<Schooling> schoolings, List<Exam> exams,
			List<Subject> subjects, List<Room> rooms, Manager manager) {
		super();
		this.name = name;
		this.city = city;
		this.department = department;
		this.open = open;
		this.close = close;
		this.activities = activities;
		this.schoolings = schoolings;
		this.exams = exams;
		this.subjects = subjects;
		this.rooms = rooms;
		this.manager = manager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	public List<Schooling> getSchoolings() {
		return schoolings;
	}

	public void setSchoolings(List<Schooling> schoolings) {
		this.schoolings = schoolings;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public void addActivity(Activity activity) {
		if (getActivities() == null) {
			this.activities = new ArrayList<>();
		}
		getActivities().add(activity);
		activity.setSchool(this);
	}

	public void addSchooling(Schooling schooling) {
		if (getSchoolings() == null) {
			this.schoolings = new ArrayList<>();
		}
		getSchoolings().add(schooling);
		schooling.setSchool(this);
	}

	public void addExam(Exam exam) {
		if (getExams() == null) {
			this.exams = new ArrayList<>();
		}
		getExams().add(exam);
		exam.setSchool(this);
	}

	public void addSubject(Subject matter) {
		if (getSubjects() == null) {
			this.subjects = new ArrayList<>();
		}
		getSubjects().add(matter);
		matter.setSchool(this);
	}

	public void addRoom(Room room) {
		if (getRooms() == null) {
			this.rooms = new ArrayList<>();
		}
		getRooms().add(room);
		room.setSchool(this);
	}
}
