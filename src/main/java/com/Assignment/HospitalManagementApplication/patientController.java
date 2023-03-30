package com.Assignment.HospitalManagementApplication;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class patientController {
	@Autowired
	patientRepo pRepo;
	
	//1.POST -> /registerPatient (Takes Patient Object as input Request Body )
	
	@PostMapping("patient/createpatientdetails")
	//Patient pt = new Patient();
	public Patient createpatientdetails(@RequestBody Patient pt) {
	return pRepo.save(pt);
	}
	
	//2.GET -> /getPatientDetails/{patientId}
	
	@GetMapping("/patient/getPatientDetails/{patientId}")
	public Patient getPatientDetails(@PathVariable(value="patientId")int patientId ){
	return pRepo.findById(patientId).get();
	}
	
	//3.GET -> /getAllPatientList
	
	@GetMapping({"/patient/getallPatientList","/"})
	public Iterable<Patient> getAllPatient(){
        return pRepo.findAll();
    }
	
	//4.PUT -> /UpdatePatient (takes patient object as input body request)
	
	@PutMapping("/patient/UpdatePatient/{patientId}")
	public ResponseEntity<Object> updatePatient(@RequestBody Patient pt,@PathVariable int patientId){
	  
		Optional<Patient> patientOptional = pRepo.findById(patientId);

		if (patientOptional.isEmpty())
			return ResponseEntity.notFound().build();

		pt.setPatientId(patientId);
		
		pRepo.save(pt);

		return ResponseEntity.noContent().build();
	}
	
	
	//5.DELETE -> /deletePatient (deletes the patient object)
	
	@DeleteMapping("/patient/DeletePatient/{patientId}")
	public void deletePatient(@PathVariable int patientId) {
		pRepo.deleteById(patientId);
	}
	  
		
}
		
	


