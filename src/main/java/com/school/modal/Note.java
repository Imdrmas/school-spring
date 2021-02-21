package com.school.modal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "notes")
public class Note extends PersistableElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private double score;

	@JsonBackReference(value = "exam")
	@ManyToOne
	private Exam exam;

	public Note() {
		super();
	}

	public Note(double score, Exam exam) {
		super();
		this.score = score;
		this.exam = exam;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
