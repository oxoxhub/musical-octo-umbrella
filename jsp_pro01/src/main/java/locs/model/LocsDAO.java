package locs.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

import dept.model.DeptDTO;

public class LocsDAO {
	
	private SqlSession session;

	public LocsDAO() {
		session = DBConn.getSqlSession();
	}

	public List<LocsDTO> searchAll() {
		List<LocsDTO> datas = session.selectList("locsMapper.locsSelectAll");
		return datas;
	}

	public LocsDTO searchLocsId(int id) {
		LocsDTO data = session.selectOne("locsMapper.locsSelectId", id);
		return data;
	}

	public boolean existCountry(String id) {
		int result = session.selectOne("locsMapper.existCountry", id);
		if(result == 1) {
			return true;
		}
		return false;
	}
	
	public boolean insertlocs(LocsDTO data) {
		int result = session.insert("locsMapper.locsInsert", data);
		if(result == 1) {
			return true;
		}
		return false;
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
