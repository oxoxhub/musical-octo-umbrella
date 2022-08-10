package com.myhome.web.board.model;

import java.sql.Date;

public class BoardStaticsDTO {
	private int id;		// PK 번호
	private int empId;	// 사용자 아이디
	private int bId;	// 글번호
	private boolean viewed;
	private Date latestViewDate;
	private boolean liked;
	
	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

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
	
	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public boolean isViewed() {
		return viewed;
	}
	
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	public Date getLatestViewDate() {
		return latestViewDate;
	}
	
	public void setLatestViewDate(Date latestViewDate) {
		this.latestViewDate = latestViewDate;
	}

	@Override
	public String toString() {
		return "EmpBoardStaticsDTO [id=" + id + ", empId=" + empId + ", bId=" + bId + ", viewed=" + viewed
				+ ", latestViewDate=" + latestViewDate + ", liked=" + liked + "]";
	}

}
