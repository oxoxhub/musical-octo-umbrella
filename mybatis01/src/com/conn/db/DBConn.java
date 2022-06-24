package com.conn.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.emp.vo.DataVO;
import com.emp.vo.EmpVO;
import com.emp.vo.EmpWhereVO;

public class DBConn {

	public static SqlSession getSqlSession() {
		
		//SqlSession 은 데이터베이스에 대해 SQL명령어를 실행하기 위해 필요한 모든 메소드를 가지고 있다. 
		//그래서 SqlSession 인스턴스를 통해 직접 SQL 구문을 실행할 수 있다.
		SqlSession sess = null;
		
		String config = "resources/mybatis-config.xml";
		InputStream is;
		
		try {
			// getResourceAsStream 는 inputStream 역할. mybatis 설정 파일을 읽어들인다.
			is = Resources.getResourceAsStream(config);
			
			// SqlSessionFactory 객체 취득
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
			
			// tomcat의 session과 DB의 session은 서로 다르다
			// SqlSession 객체를 취득 <-- 실질적으로 데이터를
			sess = sqlSessionFactory.openSession(false);
			//false=자동커밋안함(session.commit()으로 수동커밋해줘야한다) true=자동커밋
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sess;
	}
	
	public static void main(String[] args) {
		//selectOne과 selectList의 차이점은 selectOne메소드는 오직 하나의 객체만을 리턴해야 한다는 것이다. 
		//한개 이상을 리턴하거나 null 이 리턴된다면 예외가 발생할 것이다. 
		
		SqlSession session = DBConn.getSqlSession();
		int result = session.selectOne("empMapper.empCount");
		//selectOne( "mapper의 namespace입력.id입력" );
		System.out.println("1. 출력 : " + result);
		
		
		List<String> result2 = session.selectList("empMapper.empNames");
		System.out.println("2. 출력 : " + result2);
		System.out.println("2. 테스트 : " + result2.get(0)); // EllenAbel
		
		
		List<Object> result3 = session.selectList("empMapper.empDatas");
		System.out.println("3. 출력A : " + result3);
		//리스트 안에 담겨진 객체가 map 이다. mapper.xml 파일을 보면 <select id="empDatas" resultType="map"> 에 resultType에 map으로 반환하기로 설정해놨다.
		System.out.println("3. 테스트 : " + result3.get(0)); // 출력 : {EMPLOYEE_ID=100, LAST_NAME=King, FIRST_NAME=Steven}

		System.out.println("3. 출력B : ");
		for(int idx = 0; idx < result3.size(); idx++) {
			Map<String, Object> data = (Map<String, Object>)(result3.get(idx));
			//System.out.println(data) -> {EMPLOYEE_ID=100, LAST_NAME=King, FIRST_NAME=Steven} 키와 값이 쌍으로(entry) 3개 들어있다.
			//result3.get(0)은 List의 0번 인덱스의 값이며 0번 인덱스에 들어간 값이 map타입으로 3개의 entry가 들어있다.
			//반복문으로 List의 인덱스가 바뀌어 data에 계속 새로운 map타입의 entry로 바뀐다.
			System.out.println(data.get("EMPLOYEE_ID") + ", " + data.get("FIRST_NAME"));
			//data.get("EMPLOYEE_ID")에서 EMPLOYEE_ID는 map의 키key이며 해당 키의 값value을 리턴한다.
		}
		
		List<EmpVO> result4 = session.selectList("empMapper.empObjects");
		/*
			EmpVO객체의 참조값(주소)이 리스트로 담긴다. 리스트의 0번 인덱스에는 Steven의 이름과 empid,lastname이 객체로 저장되어있다.
			System.out.println(result4.get(0));
			System.out.println(result4.get(0).getFirstName());
			System.out.println(result4.get(1));
			System.out.println(result4.get(1).getFirstName());
			System.out.println(result4);
		 */
		System.out.println("4. 출력 : ");
		for(EmpVO data: result4) {
			System.out.println(data.getEmpId() + ", " + data.getFirstName());
		}
		
		System.out.println("5. 출력 : ");
		EmpVO result5 = session.selectOne("empMapper.empSelect", 100);
		System.out.println(result5.getEmpId() + ", " + result5.getFirstName());
		
		
		System.out.println("6. 출력 : ");
		Map<String,Integer> param = new HashMap<String, Integer>();
		param.put("first", 100);
		param.put("last", 110);
		//mapper.xml에서 select문에서 parameterType="map"으로 설정해줘야 함.

		List<EmpVO> result6 = session.selectList("empMapper.empRange", param);
		//mapper.xml에서 resultMap태그를 이용하였고 EmpVO객체에 담겨 반환되어왔다.
		for(EmpVO data: result6) {
			System.out.println(data.getEmpId() + ", " + data.getFirstName());
		}
		
		DataVO insertData = new DataVO();
//		insertData.setId(4);
		insertData.setName("test");
		insertData.setToday(new Date(new java.util.Date().getTime()));
		
		int result7 = session.insert("empMapper.dataInsert1", insertData);
		session.commit();
		System.out.println(result7 + " 개 행이 추가되었습니다.");	
		
//		DataVO checkData = session.selectOne("empMapper.insertCheck", insertData.getId());
//		if(checkData == null) {
//			int result7 = session.insert("empMapper.dataInsert1", insertData);
//			session.commit();
//			System.out.println(result7 + " 개 행이 추가되었습니다.");			
//		} else {
//			System.out.println("id 컬럼에 " + insertData.getId() + " 에 해당하는 데이터가 이미 존재합니다.");
//			session.rollback();
//		}
		
//		// Map<String, Object> updateData = new HashMap<String, Object>();
//		// updateData.put("id",1);
//		// updateData.put("name", "update");
//		DataVO updateData = new DataVO();
//		updateData.setId(1);
//		updateData.setName("change");
//		int result8 = session.update("empMapper.dataUpdate1", updateData);
//		session.commit();
//		System.out.println(result8 + " 개 행이 업데이트 되었습니다.");
//		
//		
//		int result9 = session.update("empMapper.dataDelete1", 1);
//		session.commit();
//		System.out.println(result9 + " 개 행이 삭제 되었습니다.");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date stDate = null, edDate = null;
		try {
			stDate = sdf.parse("1990/01/01");
			edDate = sdf.parse("1999/12/31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		EmpWhereVO dynamicData = new EmpWhereVO();
		dynamicData.setSalary(10000);
		dynamicData.setDeptId(80);
		//dynamicData.setStartDate(new Date(stDate.getTime()));
		//dynamicData.setEndDate(new Date(edDate.getTime()));
		
		List<Integer> deptList = new ArrayList<Integer>();
		deptList.add(80); deptList.add(90); deptList.add(100);
		//dynamicData.setDeptIdList(deptList);
		
		List<EmpVO> result10 = session.selectList("empMapper.dynamicQuery", dynamicData);
		System.out.println(result10.size() + " 개 행 데이터가 조회 되었습니다.");
		
		//연습문제
		// Map<String, Integer> paramData = new HashMap<String, Integer>();
		// paramData.put("deptId", 10);
		// paramData.put("stDeptId", 10);
		// paramData.put("edDeptId", 40);
		Map<String, List<Integer>> paramData = new HashMap<String, List<Integer>>();
		List<Integer> deptList2 = new ArrayList<Integer>();
		deptList2.add(10); deptList2.add(20); deptList2.add(40); deptList2.add(70);
		paramData.put("deptList", deptList2);
		
		List<Map<String, Object>> result11 = session.selectList("empMapper.empOfDeptCount", paramData);
		
		for(Map<String, Object> d: result11) {
			System.out.println(d);
		}
		
		
		// 새로운 데이터를 추가 했을 때 추가한 데이터의 ID 를 알 수 없는 문제를 해결해보도록 한다. 		
		Map<String, Object> paramData2 = new HashMap<String, Object>();
		paramData2.put("name", "newSeq");
		paramData2.put("date", new Date(new java.util.Date().getTime()));
		int id = insertSeqData(paramData2);
		if(id != -1) {
			System.out.println("ID 가 " + id + " 인 데이터가 추가 되었습니다.");
		}
		
		DataVO dataVo2 = new DataVO();
		dataVo2.setName("mybatis_seqquence");
		dataVo2.setToday(new Date(new java.util.Date().getTime()));
		int result12 = session.insert("empMapper.insertGetSeq", dataVo2);
		if(result12 == 1) {
			System.out.println("ID 가 " + dataVo2.getId() + " 인 데이터가 추가 되었습니다.");
			session.commit();
		}
	}
		
	public static int insertSeqData(Map<String, Object> param) {
		SqlSession session = DBConn.getSqlSession();
		int seq = session.selectOne("empMapper.getSeq");
		param.put("seq", seq);
		int result = session.insert("empMapper.insertSeq", param);
		
		if(result == 1) {
			session.commit();
			return seq;
		}
		session.rollback();
		return -1;
	}

}
