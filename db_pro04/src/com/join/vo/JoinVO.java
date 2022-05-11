package com.join.vo;

import java.sql.Date;

/*
 * 회원 정보를 담아 두기 위한 객체로 활용
 */
public class JoinVO {
	//Value Object
	//테이블의 행에 정보를 제공하고 행으로부터 값을 읽어와 보관할 수 있는 객체
	
	private String userid;		// 회원 아이디
	private String userpw;		// 회원 패스워드
	private String username;	// 회원 이름
	private char gender;		// 성별 ('M','F')
	private int age;			// 나이
	private Date createDate;	// 날짜
	//sql과 관련된 Date 임포트는 import java.sql.Date;
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public void setGender(String gender) {
		if(gender.charAt(0) == '남') {
			this.gender = 'M';
		} else if (gender.charAt(0) == '여'){
			this.gender = 'F';
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
}
