package com.join.dao;

import java.sql.ResultSet;
import java.util.Scanner;

import com.conn.db.DBConn;
import com.join.vo.JoinVO;

public class JoinDAO {
	//Database Access Object
	//데이터베이스의 데이터를 전문적으로 호출하고 제어하는 객체
	//실무에서도 JAVA-DB 간 JDBC 연동 시 필요한 단계 중 반복 작업들은 DAO 객체 내 저장하여 관리한다.
	
	private Scanner sc = new Scanner(System.in);
	private DBConn db;
	
	public JoinDAO() {
		try {
			db = new DBConn("localhost", "1521", "XE", "puser1", "puser1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean add(JoinVO data) {
		// 데이터 추가
		
		String query = String.format("INSERT INTO accounts VALUES('%s', '%s', '%s', '%c', %d, SYSDATE)"
				, data.getUserid()
				, data.getUserpw()
				, data.getUsername()
				, data.getGender()
				, data.getAge()
				);
		
		try {
			int result = db.sendInsertQuery(query);
			
			if(result == 1) {		// 1 반환시 성공적으로 데이터 추가된 것
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean modify(String str, String userid) {
		// 데이터 수정
		String query = String.format("UPDATE accounts SET userpw = '%s' WHERE USERID = '%s'", str, userid);
		
		try {
			int result = db.sendUpdateQuery(query);
			
			if(result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean remove(String userid) {
		// 데이터 삭제
		String query = String.format("DELETE FROM accounts WHERE USERID = '%s'", userid);
		try {
			int result = db.sendDeleteQuery(query);
			
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
		
		String query = String.format("SELECT * FROM accounts WHERE USERID = '%s'", userid);
		
		
		try {
			ResultSet rs = db.sendSelectQuery(query);
			
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
