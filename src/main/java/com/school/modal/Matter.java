package com.school.modal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "matters")
public class Matter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String color;

	@Column(columnDefinition = "TEXT")
	private String description;

	@JsonBackReference(value = "school")
	@ManyToOne
	private School school;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "matter")
	private List<Program> programs;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "matter")
	private List<Coefficient> coefficients;

	public Matter() {
		super();
	}

	public Matter(String name, String color, String description, School school, List<Program> programs,
			List<Coefficient> coefficients) {
		super();
		this.name = name;
		this.color = color;
		this.description = description;
		this.school = school;
		this.programs = programs;
		this.coefficients = coefficients;
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public List<Program> getPrograms() {
		return programs;
	}

	public void setPrograms(List<Program> programs) {
		this.programs = programs;
	}

	public List<Coefficient> getCoefficients() {
		return coefficients;
	}

	public void setCoefficients(List<Coefficient> coefficients) {
		this.coefficients = coefficients;
	}
    public void addProgram(Program program) {
	  if (getPrograms()==null) {
		this.programs = new ArrayList<>();
	}
	  getPrograms().add(program);
	  program.setMatter(this);
  }
    public void addCoefficient(Coefficient coefficient) {
    	if (getCoefficients()==null) {
			this.coefficients = new ArrayList<>();
		}
    	getCoefficients().add(null);
    	coefficient.setMatter(this);
    }
}
