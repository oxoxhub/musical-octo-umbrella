package com.conn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConn {
	
	public void localConnect() throws Exception {
		// 1.Driver 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2.DBMS 연결
		//Connection은 import java.sql.Connection; 필요
		//DriverManager는 import java.sql.DriverManager; 필요
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","puser1","puser1");
		
		// 3.Statement 생성
		//Statement는 import java.sql.Statement; 필요
		//Connection객체에 의해 프로그램에 리턴되는 객체에 의해 구현되는 일종의 메소드 집합 정의
		Statement stat = conn.createStatement();
		
		// 4.SQL 전송 / 결과 받기
		//ResultSet은 import java.sql.ResultSet; 필요
		//Connection클래스의 createStatement() 메소드를 호출하여 얻어지며
		//생성된Statement 객체로 질의문장을 String객체에 담아 인자로 전달하여 executeQuery() 메소드를 호출하여 SQL 질의 수행
		//SQL문 실행해서 테이블로부터 레코드(행)을 전달받아서 결과 집합을 만들고 ResultSet 객체에 담아서 반환
		//ResultSet rs = stat.executeQuery("SELECT * FROM DEPARTMENTS");
		
		/*
		 * 1.컬럼명을 통해서 데이터를 반환하는 방법
		 * getString(컬럼명) : 컬럼명과 매칭되어 있는 데이터를 String 타입으로 반환
		 * System.out.println(rs.getString("id"));
		 * 
		 * getInt(컬럼명) : 컬럼명과 매칭되어 있는 데이터를 Int타입으로 반환
		 * System.out.println(rs.getInt("age"));
		 * 
		 * 2.컬럼 인덱스를 통해서 데이터를 반환하는 방법
		 * System.out.println(rs.getString(1));
		 */
		
		//int rowCount = stat.executeUpdate("INSERT INTO DEPARTMENTS (DEPARTMENT_ID,DEPARTMENT_NAME) VALUES(280, 'Tester')"); //삽입 작업후 삽입한 행의 갯수를 반환
		//int rowCount = stat.executeUpdate("UPDATE DEPARTMENTS SET DEPARTMENT_NAME = 'Dept Tester' WHERE DEPARTMENT_ID = 280");
		int rowCount = stat.executeUpdate("DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = 280");
		System.out.println(rowCount + "개 행이 반영되었습니다.");
		
		//next() : ResultSet에서 결과집합의 행에 접근할 때 커서를 사용하는데, 커서를 다음행으로 이동시키고 다음행이 존재하면 true 반환
		ResultSet rs = stat.executeQuery("SELECT * FROM DEPARTMENTS");
		while(rs.next()) {
			System.out.print(rs.getString(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getString(3) + "\t");
			System.out.print(rs.getString(4) + "\n");
		}
		
		// 5.닫기(객체 반환)
		rs.close();
		stat.close();
		conn.close();
		
	}

	public static void main(String[] args) throws Exception {
		DBConn myDB = new DBConn();
		myDB.localConnect();

	}

}
