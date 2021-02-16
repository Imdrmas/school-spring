package com.school.modal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "schools")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String city;

	@Column(columnDefinition = "TEXT")
	private String description;

	private String department;

	private String open;

	private String close;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Activity> activities;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Schooling> schoolings;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Exam> exams;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Matter> matters;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
	private List<Room> rooms;

	@OneToOne(mappedBy = "school")
	private Manager manager;

	public School() {
		super();
	}

	public School(String name, String city, String description, String department, String open, String close,
			Date createAt, List<Activity> activities, List<Schooling> schoolings, List<Exam> exams,
			List<Matter> matters, List<Room> rooms, Manager manager) {
		super();
		this.name = name;
		this.city = city;
		this.description = description;
		this.department = department;
		this.open = open;
		this.close = close;
		this.createAt = createAt;
		this.activities = activities;
		this.schoolings = schoolings;
		this.exams = exams;
		this.matters = matters;
		this.rooms = rooms;
		this.manager = manager;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
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

	public List<Matter> getMatters() {
		return matters;
	}

	public void setMatters(List<Matter> matters) {
		this.matters = matters;
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

	public void addMatter(Matter matter) {
		if (getMatters() == null) {
			this.matters = new ArrayList<>();
		}
		getMatters().add(matter);
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
