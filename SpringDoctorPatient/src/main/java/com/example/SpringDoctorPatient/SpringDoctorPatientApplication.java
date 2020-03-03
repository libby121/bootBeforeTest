package com.example.SpringDoctorPatient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.SpringDoctorPatient.beans.Doctor;
import com.example.SpringDoctorPatient.beans.Patient;
import com.example.SpringDoctorPatient.facades.ManagerFacade;

@SpringBootApplication
public class SpringDoctorPatientApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx=	SpringApplication.run(SpringDoctorPatientApplication.class, args);
	
	ManagerFacade meni=ctx.getBean(ManagerFacade.class);
	
//	meni.addDoctor(new Doctor("meni","bla"));
//	meni.addDoctor(new Doctor("meni2","bla"));
//	meni.addDoctor(new Doctor("meni3","bla"));
//	meni.addDoctor(new Doctor("meni4","bla"));
//	meni.addPatient(new Patient("shabi", "someShit", 12, meni.getDocotr(1)));
//	meni.addPatient(new Patient("shabi2", "someShit", 122, meni.getDocotr(1)));
//	meni.addPatient(new Patient("shabi3", "someShit", 121, meni.getDocotr(2)));
//	meni.addPatient(new Patient("shabi4", "someShit", 124, meni.getDocotr(3)));
	
	//System.out.println(meni.getAllDocs());
	//System.out.println(meni.getAllPatient());
	//System.out.println(meni.getDocotr(5));
	//System.out.println(meni.getPat(6));
	
	meni.getDocotr(5).getPatients().add(meni.getPat(6));
	meni.updateDoctor(meni.getDocotr(5));
	//meni.deleteDoc(1);
	
	//meni.deletePat(1);
	}

}
