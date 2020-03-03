package com.example.SpringDoctorPatient.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringDoctorPatient.beans.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

	List<Patient>findByDoctorId(long id);
}
