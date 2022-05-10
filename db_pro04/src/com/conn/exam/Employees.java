package com.conn.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import com.conn.db.DBConn;

public class Employees {
	
	
	public void getSalary(int salary) throws Exception {
		/*
		 * salary에 해당하는 데이터를 조회하여 출력해보기.
		 * 출력에 사용할 컬럼은 EMPLOYEE_ID, FIRST_NAME, LSAT_NAME, SALARY 로 한다.
		 */
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","puser1","puser1");
		
		Statement stat = conn.createStatement();
		
		ResultSet rs = stat.executeQuery("SELECT * FROM EMPLOYEES");
		
		while(rs.next()) {
			int i = Integer.parseInt(rs.getString("SALARY"));
			if(salary == i) {
				System.out.println(rs.getString("EMPLOYEE_ID"));
				System.out.println(rs.getString("FIRST_NAME"));
				System.out.println(rs.getString("LAST_NAME"));
				System.out.println(rs.getString("SALARY"));
			}
		}
		
		rs.close();
		stat.close();
		conn.close();
		
	}
	
	public static void main(String[] args) throws Exception{
		Employees emp = new Employees();
		emp.getSalary(24000);
		
	}

}
