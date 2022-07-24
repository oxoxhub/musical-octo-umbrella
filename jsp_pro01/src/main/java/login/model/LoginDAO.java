package login.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

import emps.model.EmpsDTO;

public class LoginDAO {

	private SqlSession session = DBConn.getSqlSession();
	
	public EmpsDTO selectLogin(Map<String, Object> mapData) {
		//직원 정보 조회 후  가져오기
		EmpsDTO data = session.selectOne("loginMapper.selectLogin", mapData);
		return data;
	}

	public List<PermDTO> selectPerm(int id) {
		//직원 권한 조회 후 권한 정보 가져오기
		List<PermDTO> data = session.selectList("loginMapper.selectPerm", id);
		return data;
	}

	public void commit() {
		session.commit();
	}
	
	public void rollback() {
		session.rollback();
	}
	
	public void close() {
		session.close();
	}

}
