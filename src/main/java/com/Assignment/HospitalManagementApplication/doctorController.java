package com.Assignment.HospitalManagementApplication;

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
public class doctorController {
	
	
	@Autowired
	doctorRepo dRepo;
	
	
	//6./registerDoctor
	
	@PostMapping("/registerDoctor")
	public Doctor registerDoctor(@RequestBody Doctor doctor) {
		return dRepo.save(doctor);
	}
	
    
		
	//7./getDoctorDetails/{doctorId}
     
		@GetMapping("/getDoctorDetails/{doctorId}")
		public Doctor getDoctorDetails(@PathVariable(value="doctorId")int doctorId) {
		 return dRepo.findById(doctorId).get();	
		}
		
		//8. /getAllDoctorList
    
		@GetMapping({"/getAllDoctorList","/"})
		public Iterable<Doctor> getAllDoctorList(){
			return dRepo.findAll();
		}
   
       //9. /updateDoctor
		@PutMapping("/UpdateDoctor/{doctorId}")
		public ResponseEntity<Object> UpdateDoctor(@RequestBody Doctor doctor,@PathVariable int doctorId){
		 Optional<Doctor> doctorOptional = dRepo.findById(doctorId);
		 if (doctorOptional.isEmpty())
			 return ResponseEntity.notFound().build();
		 doctor.setDoctorId(doctorId);
		 dRepo.save(doctor);
		 return ResponseEntity.noContent().build();
		}
    
   
	//10./deleteDoctor
    
		@DeleteMapping("/DeleteDoctor/{doctorId}")
		public void deloeteDoctor(@PathVariable int doctorId) {
			dRepo.deleteById(doctorId);
		}
    

}
