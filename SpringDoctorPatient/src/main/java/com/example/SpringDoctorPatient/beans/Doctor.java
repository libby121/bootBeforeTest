package com.example.SpringDoctorPatient.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="doctors")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	
	@Column
	private String internship;
	
	@OneToMany(mappedBy="doctor", fetch=FetchType.EAGER)// cascade=CascadeType.REMOVE) father
	private List<Patient>patients;

	public Doctor() {
		super();
	}

	public Doctor(String name, String internship) {
		super();
		this.name = name;
		this.internship = internship;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInternship() {
		return internship;
	}

	public void setInternship(String internship) {
		this.internship = internship;
	}

	public long getId() {
		return id;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", internship=" + internship + "]";
	}
	
	
}
