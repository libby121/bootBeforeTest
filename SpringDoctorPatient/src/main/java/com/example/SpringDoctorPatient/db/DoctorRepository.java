package com.example.SpringDoctorPatient.db;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringDoctorPatient.beans.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
