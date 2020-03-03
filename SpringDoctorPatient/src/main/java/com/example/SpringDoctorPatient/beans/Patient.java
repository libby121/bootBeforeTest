package com.example.SpringDoctorPatient.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column
	private String name;
	@Column
	private String diagnosis;
	@Column
	private int daysInHospital;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Doctor doctor;

	public Patient() {
		super();
	}

	public Patient(String name, String diagnosis, int daysInHospital, Doctor doctor) {
		super();
		this.name = name;
		this.diagnosis = diagnosis;
		this.daysInHospital = daysInHospital;
		this.doctor = doctor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public int getDaysInHospital() {
		return daysInHospital;
	}

	public void setDaysInHospital(int daysInHospital) {
		this.daysInHospital = daysInHospital;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", diagnosis=" + diagnosis + ", daysInHospital="
				+ daysInHospital + ", doctor=" + doctor + "]";
	}
	
	
	
}