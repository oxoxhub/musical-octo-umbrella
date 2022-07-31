package board.model;

import java.sql.Date;

public class EmpBoardStaticsDTO {
	private int id;
	private int empId;
	private int bId;
	private boolean viewed;
	private Date latesViewDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getEmpId() {
		return empId;
	}
	
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	
	public int getBId() {
		return bId;
	}
	
	public void setBId(int bId) {
		this.bId = bId;
	}
	
	public boolean isViewed() {
		return viewed;
	}
	
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	public Date getLatesViewDate() {
		return latesViewDate;
	}
	
	public void setLatesViewDate(Date latesViewDate) {
		this.latesViewDate = latesViewDate;
	}
	
	@Override
	public String toString() {
		return "EmpBoardStaticsDTO [id=" + id + ", empId=" + empId + ", bId=" + bId + ", viewed=" + viewed
				+ ", latesViewDate=" + latesViewDate + "]";
	}
	
	
}
