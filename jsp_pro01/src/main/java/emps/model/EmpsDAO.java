package emps.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public class EmpsDAO {
	
	private SqlSession session = DBConn.getSqlSession();
	private String mapper =  "empsMapper.%s";
	
	public Map<String, Integer> checkSalaryRange(String id) {
		String mapId = String.format(mapper, "checkSalaryRange");
		Map<String, Integer> data = session.selectOne(mapId, id);
		return data;
	}
	
	public List<EmpsDTO> selectAll() {
		String mapId = String.format(mapper, "selectAll");
		List<EmpsDTO> datas = session.selectList(mapId);
		return datas;
	}
	
	public List<EmpsAllDTO> selectEmps() {
		String mapId = String.format(mapper, "selectEmps");
		List<EmpsAllDTO> datas = session.selectList(mapId);
		return datas;
	}
	
	public List<EmpsDTO> selectPage(int id, int start, int end) {
		String mapId = String.format(mapper, "selectPage");
		Map<String, Integer> page = new HashMap<String, Integer>();
		page.put("deptId", id);
		page.put("start", start);
		page.put("end", end);
		List<EmpsDTO> datas = session.selectList(mapId, page);
		return datas;
	}
	
	public int rowCount(int id) {
		String mapId = String.format(mapper, "rowCount");
		int result = session.selectOne(mapId, id);
		return result;
	}
	
	/*
	public List<EmpsDTO> selectPage(int start, int end, String sort) {
		String mapId = String.format(mapper, "selectPage");
		Map<String,Integer> page = new HashMap<String,Integer>();
		page.put("start", start);
		page.put("end", end);
		
		switch(sort) {
		case "empId":
			page.put("sort", 1); break;
		case "empName":
			page.put("sort", 2); break;
		case "email":
			page.put("sort", 3); break;
		case "jobName":
			page.put("sort", 4); break;
		case "deptName":
			page.put("sort", 5); break;
		}
		
		List<EmpsDTO> datas = session.selectList(mapId, page);
		return datas;
	}
	*/
	
	public EmpsDetailDTO selectEmpDetail(int empId) {
		String mapId = String.format(mapper, "selectEmpDetail");
		EmpsDetailDTO data = session.selectOne(mapId, empId);
		return data;
	}
	
	
	public boolean updateEmp(EmpsDTO empsData) {
		String mapId = String.format(mapper, "updateEmp");
		int result = session.update(mapId, empsData);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public boolean updateEmpDetail(EmpsDetailDTO empsDetailData) {
		String mapId = String.format(mapper, "updateEmpDetail");
		int result = session.update(mapId, empsDetailData);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	/*
	public boolean insertEmps(EmpsAllDTO empsData) {
		String mapId = String.format(mapper, "insertEmp");
		int result = session.insert(mapId, empsData);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public EmpsAllDTO searchEmpsId(int id) {
		// employees id 찾기
		String mapId = String.format(mapper, "selectAllEmps");
		EmpsAllDTO data = session.selectOne(mapId, id);
		return data;
	}
	
	public boolean existEmail(String email) {
		// employees email 중복 확인
		String mapId = String.format(mapper, "existEmail");
		int result = session.selectOne(mapId, email);
		if(result == 1) {
			//이메일 중복이다
			return true;
		}
		return false;
	}
	
	public boolean existJobId(String jobId) {
		// jobs job_id 데이터 유무 확인
		String mapId = String.format(mapper, "existJobId");
		int result = session.selectOne(mapId, jobId);
		if(result == 1) {
			// jobs 테이블에 데이터 있음
			return true;
		}
		return false;
	}
	
	public boolean existDeptId(int deptId) {
		// deptId department 데이터 유무 확인
		String mapId = String.format(mapper, "existDeptId");
		int result = session.selectOne(mapId, deptId);
		if(result == 1) {
			// department 테이블에 데이터 있음
			return true;
		}
		return false;
	}
	
	public boolean updateEmps(EmpsAllDTO empsData) {
		String mapId = String.format(mapper, "updateEmps");
		int result = session.update(mapId, empsData);
		if(result == 1) {
			return true;
		}
		return false;
	}
	*/
	
	public void commit() {
		session.commit();
	}
	
	public void rollback() {
		session.rollback();
	}
	
	public void close() {
		session.close();
	}
	
	public boolean insertEmp(EmpsDTO empsData) {
		String mapId = String.format(mapper, "insertEmp");
		int result = session.insert(mapId, empsData);
		if(result == 1) {
			return true;
		}
		return false;
	}

	public EmpsDTO selectId(int id) {
		String mapId = String.format(mapper, "selectId");
		EmpsDTO data = session.selectOne(mapId, id);
		return data;
	}

	public boolean deleteId(int id) {
		String mapId = String.format(mapper, "deleteId");
		int result = session.delete(mapId, id);
		return result == 1 ? true : false;
	}

}
