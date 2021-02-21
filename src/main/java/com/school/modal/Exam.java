package com.school.modal;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "exams")
public class Exam extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String date;

	private String start;

	private String end;

	@JsonBackReference(value = "school")
	@ManyToOne
	private School school;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "exam")
	private List<Note> notes;

	@JsonBackReference(value = "subject")
	@OneToOne(cascade = CascadeType.ALL)
	private Subject subject;

	public Exam() {
		super();
	}

	public Exam(String date, String start, String end, School school, List<Note> notes,
			Subject subject) {
		super();
		this.date = date;
		this.start = start;
		this.end = end;
		this.school = school;
		this.notes = notes;
		this.subject = subject;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subjects) {
		this.subject = subjects;
	}

	public void addNote(Note note) {
		if (getNotes() == null) {
			this.notes = new ArrayList<>();
		}
		getNotes().add(note);
		note.setExam(this);
	}

}
