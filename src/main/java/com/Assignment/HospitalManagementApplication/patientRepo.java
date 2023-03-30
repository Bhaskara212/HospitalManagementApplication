package com.Assignment.HospitalManagementApplication;


import org.springframework.data.repository.CrudRepository;

public interface patientRepo extends CrudRepository<Patient,Integer> {

}
