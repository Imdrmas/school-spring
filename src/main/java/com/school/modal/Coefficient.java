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
@Table(name = "coefficients")
public class Coefficient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int grade;

	@Column(columnDefinition = "TEXT")
	private String description;

	@JsonBackReference(value = "matter")
	@ManyToOne
	private Matter matter;

	public Coefficient() {
		super();
	}

	public Coefficient(int grade, String description, Matter matter) {
		super();
		this.grade = grade;
		this.description = description;
		this.matter = matter;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Matter getMatter() {
		return matter;
	}

	public void setMatter(Matter matter) {
		this.matter = matter;
	}

}
