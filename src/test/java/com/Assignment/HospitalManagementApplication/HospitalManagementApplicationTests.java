package com.Assignment.HospitalManagementApplication;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalManagementApplicationTests {
	
	@Autowired
	private patientRepo pRepo;
	@Autowired
	private doctorRepo dRepo;
	
	@Autowired
	private patientController pController;
	@Autowired
	private doctorController dController;
	
	private Patient patient;
	
	private Doctor doctor;
	
	@Test
	void contextLoads() {
	}
	
	
	//1.CreatePatient Details
	
	@Test
	public void Testcreatepatientdetails() {
		Patient patient = pRepo.save(new Patient(1001,"Rammohan",67,939393551));
		assertThat(patient.getPatientId()).isGreaterThan(0);
	}

	
	//2.Find Patient Details by Id
	
	@Test
	public void testgetPatientDetails() {
		Patient patient = pRepo.save(new Patient(1001,"Rammohan",67,939393551));
		Patient patientlistbyId = pRepo.findById(patient.getPatientId()).get();
        assertThat(patientlistbyId).isNotNull();
	}
		
		   
	//3.Get All Patient List
	@Test
	public void testgetAllPatient() {
		Patient patient = new Patient(1001,"Rammohan",67,939393551);
		Patient patient1 = new Patient(1002,"Ravi",42,900001011);
		Iterable<Patient> patientList = pRepo.findAll();
		assertThat(patientList).isNotNull();
		assertThat(patientList.iterator()).isNotEqualTo(2);
	}
		
		
	//4.Update Patient Details by Id 
	@Test
	public void testupdatePatient() {
		Patient patient = pRepo.save(new Patient(1001,"Rammohan",67,939393551));
		Patient updatePatient = pRepo.findById(patient.getPatientId()).get();
		updatePatient.setPatientName("Santosh");
		updatePatient.setPatientAge(58);
		Patient updatepatient = pRepo.save(updatePatient);
		assertThat(updatepatient.getPatientName()).isEqualTo("Santosh");
		assertThat(updatepatient.getPatientAge()).isEqualTo(58);
	}
		
	//5.Delete Patient Details by Id
	@Test
	public void testdeletePatient() {
		Patient patient = pRepo.save(new Patient(1001,"Rammohan",67,939393551));
		pRepo.deleteById(patient.getPatientId());
		Optional<Patient> optionalPatient = pRepo.findById(patient.getPatientId());
		assertThat(optionalPatient).isEmpty();
	}
	
	
	//6.CreateDoctor Details
	@Test
	public void testCreateDoctormethod() {
		Doctor doctor =dRepo.save(new Doctor(101,"Krishna","Radiology",917781665));
		assertThat(doctor.getDoctorId()).isGreaterThan(0);
		
	}
			
	//7.Find Doctor Details by Id
	@Test
	public void testgetDoctorDetailsmethod() {
		Doctor doctor =dRepo.save(new Doctor(101,"Krishna","Radiology",917781665));
		Doctor doctorListById = dRepo.findById(doctor.getDoctorId()).get();
		assertThat(doctorListById).isNotNull();
		}
			
	//8.Get All Doctor list
	@Test
	public void testgetAllDoctorListmethod() {
		Doctor doctor = new Doctor(101,"Krishna","Radiology",917781665);
		Doctor doctor1 = new Doctor(102,"Ramyasri","Cardiologist",799344758);
		Iterable<Doctor> doctorAllList = dRepo.findAll();
		assertThat(doctorAllList).isNotNull();
		assertThat(doctorAllList.iterator()).isNotEqualTo(2);
		
	}
			
	
	//4.Update Doctor Details by Id
	@Test
	public void testUpdateDoctorDetails() {
		Doctor doctor =dRepo.save(new Doctor(101,"Krishna","Radiology",917781665));
		Doctor savedDoctor = dRepo.findById(doctor.getDoctorId()).get();
		savedDoctor.setDMobileNo(950503279);
		savedDoctor.setDoctorName("Bhaskara");
		Doctor updateDoctorDetails = dRepo.save(savedDoctor);
		assertThat(updateDoctorDetails.getDMobileNo()).isEqualTo(950503279);
		assertThat(updateDoctorDetails.getDoctorName()).isEqualTo("Bhaskara");
	}
			
			
	//5.Delete Doctor Details by id
	@Test
	public void testdeleteDoctor() {
		Doctor doctor =dRepo.save(new Doctor(101,"Krishna","Radiology",917781665));
		dRepo.deleteById(doctor.getDoctorId());
		Optional<Doctor> optionaldoctor =dRepo.findById(doctor.getDoctorId());
		assertThat(optionaldoctor).isEmpty();
	}
			
		
	
}
