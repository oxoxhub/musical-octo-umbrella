package com.myhome.web.login.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.web.emp.model.EmpDTO;
import com.myhome.web.login.controller.LoginController;
import com.myhome.web.login.model.LoginDAO;
import com.myhome.web.login.vo.LoginVO;

@Service
public class LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private LoginDAO dao;
	
	public boolean getLogin(HttpSession session, LoginVO loginVo) {
		logger.info("getLogin({}, {})", session, loginVo);
		
		EmpDTO data = new EmpDTO();
		data.setEmpId(loginVo.getEmpId());
		data.setDeptId(loginVo.getDeptId());
		data.setEmpName(loginVo.getEmpName());

		data = dao.selectLogin(data);	//직원 조회
		
		if(data == null) {
			// 조회 결과 없음
			return false;
		} else {
			// 조회 결과 있음
			// List<PermDTO> perm = dao.selectPerm(data.getEmpId());
			session.setAttribute("loginData", data);	//직원에대한 정보 세션에 저장
			// session.setAttribute("permData", perm);		//직원의 권한 정보 세션에 저장
			return true;
		}
		
	}

}
