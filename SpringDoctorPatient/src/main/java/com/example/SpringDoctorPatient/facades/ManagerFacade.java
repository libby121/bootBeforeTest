package com.example.SpringDoctorPatient.facades;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringDoctorPatient.beans.Doctor;
import com.example.SpringDoctorPatient.beans.Patient;
import com.example.SpringDoctorPatient.db.DoctorRepository;
import com.example.SpringDoctorPatient.db.PatientRepository;

@Service
public class ManagerFacade {

	
	@Autowired
	private DoctorRepository docRepo;
	
	@Autowired
	private PatientRepository patRepo;

public void addDoctor(Doctor doc) {
	docRepo.save(doc);
}

public void addPatient(Patient pat) {
	patRepo.save(pat);
}

public void updateDoctor(Doctor doc) {
if(	docRepo.existsById(doc.getId()))docRepo.save(doc);
}

public void updatePatient(Patient pat) {
	if(patRepo.existsById(pat.getId()))patRepo.save(pat);
}

public List<Doctor>getAllDocs(){
return	docRepo.findAll();
}

public List<Patient>getAllPatient(){
	return patRepo.findAll();
}

public Doctor getDocotr(long id) {
	return docRepo.findById(id).orElse(null);
}

public Patient getPat(long id) {
	return patRepo.findById(id).orElse(null);
}

public void deleteDoc(long id) {
for (Patient p : patRepo.findByDoctorId(id)) {
	//patRepo.delete(p);
	p.setDoctor(null);
	updatePatient(p);
}
	docRepo.deleteById(id);
}
public void deletePat(long id) {
	patRepo.deleteById(id);
}
}
