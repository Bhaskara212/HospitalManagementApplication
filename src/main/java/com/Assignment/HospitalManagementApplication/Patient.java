package com.Assignment.HospitalManagementApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Patient {
	@Id
	private int patientId;
	private String patientName;
	private int patientAge;
	private long mobileNo;
	
	
	public Patient() {
	}
	
		public Patient(int patientId,String patientName,int patientAge,long mobileNo) {
	      this.patientId=patientId;
	      this.patientName=patientName;
	      this.patientAge=patientAge;
	      this.mobileNo=mobileNo;
		}
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public long getmobileNo() {
		return mobileNo;
	}
	public void setmobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	
	
}
