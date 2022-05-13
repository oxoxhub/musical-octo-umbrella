package com.conn.exam;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.conn.db.DBConn;

public class Employees {
	
	private DBConn db;
	
	public Employees() {
		try {
//			db = new DBConn("localhost", "1521", "XE", "puser1", "puser1");
			db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void getSalary(int salary) throws Exception {
		/*
		 * salary에 해당하는 데이터를 조회하여 출력해보기.
		 * 출력에 사용할 컬럼은 EMPLOYEE_ID, FIRST_NAME, LSAT_NAME, SALARY 로 한다.
		 */
		
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES WHERE SALARY = ? ";
		try {
			PreparedStatement pstat = db.getPstat(query);
			pstat.setInt(1, salary);
			
			ResultSet rs = db.sendSelectQuery();
			while(rs.next()) {
				System.out.println("EMPLOYEE_ID : " + rs.getInt("EMPLOYEE_ID"));
				System.out.println("FIRST_NAME : " + rs.getString("FIRST_NAME"));
				System.out.println("LAST_NAME : " + rs.getString("LAST_NAME"));
				System.out.println("SALARY : " + rs.getInt("SALARY"));
				System.out.println("-------------------------------------");
			}
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		Employees emp = new Employees();
		emp.getSalary(10000);
		emp.close();
	}

}
