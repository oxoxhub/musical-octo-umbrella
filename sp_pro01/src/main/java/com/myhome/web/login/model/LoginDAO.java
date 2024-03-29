package com.myhome.web.login.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.web.emp.model.EmpDTO;
import com.myhome.web.login.service.LoginService;

@Repository
public class LoginDAO {
	
	@Autowired
	private SqlSession session;
	
	public EmpDTO selectLogin(EmpDTO data) {
		//직원 정보 조회 후  가져오기
		EmpDTO result = session.selectOne("loginMapper.selectLogin", data);
		return result;
	}
	
	public List<PermDTO> selectPerm(int id) {
		List<PermDTO> data = session.selectList("loginMapper.selectPerm", id);
		return data;
	}

}
