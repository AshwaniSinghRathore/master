package com.niit.cruddemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;

	@NonNull 
	private String empName;

	@NonNull 
	private String empPassword;
	@NonNull
	private String empAddress;
	@NonNull
	@Column(name="email",unique=true)
	private String empEmail;
	@NonNull
	private int empMobileNo;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public int getEmpMobileNo() {
		return empMobileNo;
	}
	public void setEmpMobileNo(int empMobileNo) {
		this.empMobileNo = empMobileNo;
	}
	 
	//private String empDob;
	 
	 
	 
	/*private String empLocation;
	 
	private int empExperience;
	 
	private String empQualification;
	 
	private String empRole;

	 
	private String empCertificate;
	 
	private String empStatus;
	
	private String empManager;*/
	
	
	
}
	 