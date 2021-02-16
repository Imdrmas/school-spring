package com.school.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "exams")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String day;

	private String start;

	private String end;

	@JsonBackReference(value = "school")
	@ManyToOne
	private School school;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "exam")
	private List<Note> notes;

	public Exam() {
		super();
	}

	public Exam(String day, String start, String end, School school, List<Note> notes) {
		super();
		this.day = day;
		this.start = start;
		this.end = end;
		this.school = school;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public void addNote(Note note) {
		if (getNotes()==null) {
			this.notes = new ArrayList<>();
		}
		getNotes().add(note);
		note.setExam(this);
	}
}
