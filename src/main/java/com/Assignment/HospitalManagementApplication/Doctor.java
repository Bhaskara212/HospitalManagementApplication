package com.Assignment.HospitalManagementApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Doctor {
	@Id
	private int doctorId;
	private String doctorName;
	private String specialist ;
	private long dmobileNo;
	
	public Doctor() {
	
	}
	
	public Doctor(int doctorId,String doctorName,String specialist,long dmobileNo){
	this.doctorId=doctorId;
	this.doctorName=doctorName;
	this.specialist=specialist;
	this.dmobileNo=dmobileNo;
	}	
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public long getDMobileNo() {
		return dmobileNo;
	}
	public void setDMobileNo(long dmobileNo) {
		this.dmobileNo = dmobileNo;
	}
}
