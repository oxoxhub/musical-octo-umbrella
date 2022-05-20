package com.join.dao;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.conn.db.DBConn;
import com.join.vo.JoinVO;

public class JoinDAO {
	//Database Access Object
	//데이터베이스의 데이터를 전문적으로 호출하고 제어하는 객체
	//실무에서도 JAVA-DB 간 JDBC 연동 시 필요한 단계 중 반복 작업들은 DAO 객체 내 저장하여 관리한다.
	
	private DBConn db;
	
	public JoinDAO() {
		try {
			db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean add(JoinVO data) {
		// 데이터 추가
		
		String query = "INSERT INTO accounts VALUES(?, ?, ?, ?, ?, SYSDATE)";

		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getUserid());
			pstat.setString(2, data.getUserpw());
			pstat.setString(3, data.getUsername());
			pstat.setString(4, Character.toString(data.getGender()));
			pstat.setInt(5, data.getAge());
			
			int result = db.sendInsertQuery();
			
			if(result == 1) {		// 1 반환시 성공적으로 데이터 추가된 것
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean modify(JoinVO data) {
		// 데이터 수정
		String query = ""
				+ "UPDATE accounts" 
				+ "   SET USERPW = ?"
				+ "     , USERNAME = ?"
				+ "     , GENDER = ?"
				+ "     , AGE = ?"
				+ " WHERE USERID = ?";
		
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getUserpw());
			pstat.setString(2, data.getUsername());
			pstat.setString(3, Character.toString(data.getGender()));
			pstat.setInt(4, data.getAge());
			pstat.setString(5, data.getUserid());
			
			int result = db.sendUpdateQuery();
			
			if(result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean remove(JoinVO data) {
		// 데이터 삭제
		String query = "DELETE FROM accounts WHERE USERID = ?";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, data.getUserid());
			
			int result = db.sendDeleteQuery();
			
			if(result == 1) {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public JoinVO get(String userid) {
		// 단일 데이터 조회
		
		String query = "SELECT * FROM accounts WHERE USERID = ?";
		
		
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setString(1, userid);

			ResultSet rs = db.sendSelectQuery();
			
			if(rs.next()) {
				JoinVO data = new JoinVO();
				data.setUserid(rs.getString("USERID"));
				data.setUserpw(rs.getString("USERPW"));
				data.setUsername(rs.getString("USERNAME"));
				data.setGender(rs.getString("GENDER").charAt(0));
				data.setAge(rs.getInt("AGE"));
				data.setCreateDate(rs.getDate("CREATEDATE"));
				return data;
				//db에 있는 데이터를 get하여 JoinVO 객체에 set담아주는 과정 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	

}
