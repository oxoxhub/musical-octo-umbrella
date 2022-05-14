package com.conn.db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBConn {
	
	private final static String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final static String BASE_URL = "jdbc:oracle:thin:@";
	
	private String url_address;
	private Connection conn;
	//private Statement stat;
	private PreparedStatement pstat;
	
	public DBConn(File config) throws Exception {
		
			Map<String, String> map = new HashMap<String, String>();
			BufferedReader br = new BufferedReader(new FileReader(config));
			StringBuilder sb = new StringBuilder();
			
			while(br.ready()){
				String[] kv = br.readLine().split("=");
				map.put(kv[0].strip(), kv[1].strip());
			}
			
			System.out.println(map);
			
			url_address = String.format("%s:%s/%s", map.get("host"), map.get("port"), map.get("service"));
			this.createConnection(map.get("username"), map.get("password"));
		
	}
	
	public static void main(String[] args) throws Exception {
		DBConn db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
	}
	
	public DBConn(String address, String port, String serviceName, String username, String password) throws Exception {
		url_address = String.format("%s:%s/%s", address, port, serviceName);
		this.createConnection(username, password);
	}
	
	//public DBConn(String tnsAlias, String walletPath, String username, String password) {} 오라클 클라우드 이용시
	
	private void createConnection(String username, String password) throws Exception {
		// 1.Driver 등록
		Class.forName(DRIVER_NAME);
		
		// 2.DBMS 연결
		//Connection은 import java.sql.Connection; 필요
		//DriverManager는 import java.sql.DriverManager; 필요
		conn = DriverManager.getConnection(BASE_URL + url_address, username, password);
		
		// 3.Statement 생성
		//Statement는 import java.sql.Statement; 필요
		//Connection객체에 의해 프로그램에 리턴되는 객체에 의해 구현되는 일종의 메소드 집합 정의
		//stat = conn.createStatement();
		
	}
	
	public PreparedStatement getPstat(String query) throws Exception {
		pstat = conn.prepareStatement(query);
		return pstat;
	}
	
	public ResultSet sendSelectQuery() throws Exception {
		return this.pstat.executeQuery();
	}
	
	public int sendInsertQuery() throws Exception {
		return this.pstat.executeUpdate();
	}

	public int sendUpdateQuery() throws Exception {
		return this.pstat.executeUpdate();
	}
	
	public int sendDeleteQuery() throws Exception {
		return this.pstat.executeUpdate();
	}
	
	public void close() throws Exception {
		this.pstat.close();
		this.conn.close();
	}


//	public static void main(String[] args) throws Exception {
//		DBConn myDB = new DBConn();
//		myDB.localConnect();
//
//	}

}
