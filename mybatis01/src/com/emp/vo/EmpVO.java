package com.emp.vo;

import java.util.List;

public class EmpVO {
	private int empId;
	private String firstName;
	private String lastName;
	private int salary;
	private String jobId;
	private List<String> jobIdList;
	
	
	public List<String> getJobIdList() {
		return jobIdList;
	}
	public void setJobIdList(List<String> jobIdList) {
		this.jobIdList = jobIdList;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
