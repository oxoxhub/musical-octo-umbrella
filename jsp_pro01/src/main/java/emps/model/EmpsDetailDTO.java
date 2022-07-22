package emps.model;

import java.sql.Date;

public class EmpsDetailDTO {
	private int empId;
	private Date hireDate;
	private String phone;
	private int salary;
	private double commission;
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = Integer.parseInt(empId);
	}
	
	public Date getHireDate() {
		return hireDate;
	}
	
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	public void setHireDate(String hireDate) {
		if(hireDate == null || hireDate.isEmpty()) {
			this.hireDate = new Date(new java.util.Date().getTime());
		} else {
			this.hireDate = Date.valueOf(hireDate);			
		}
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void setSalary(String salary) {
		if(salary == null || salary.isEmpty()) {
			this.salary = 0;
		} else {
			this.salary = Integer.parseInt(salary);
		}
	}
	
	public double getCommission() {
		return commission;
	}
	
	public void setCommission(double commission) {
		if(commission >= 1) {
			commission /= 100;
		}
		this.commission = commission;
	}
	
	public void setCommission(String commission) {
		if(commission == null || commission.isEmpty()) {
			this.commission = 0;
		} else {
			setCommission(Double.parseDouble(commission));
		}
	}
	
	@Override
	public String toString() {
		return "EmpsDetailDTO [empId=" + empId + ", hireDate=" + hireDate + ", phone=" + phone + ", salary=" + salary
				+ ", commission=" + commission + "]";
	}
	
}
