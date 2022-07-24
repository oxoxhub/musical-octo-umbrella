package login.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import emps.model.EmpsDTO;
import login.model.LoginDAO;
import login.model.PermDTO;

public class LoginService {

	public boolean getLogin(HttpSession session, String empId, String deptId, String empName) {
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("empId", empId);
		mapData.put("deptId", deptId);
		mapData.put("firstName", "");
		mapData.put("lastName", "");
		
		String fullName[] = empName.split(" ", 2);
		if(fullName.length == 2) {
			mapData.put("firstName", fullName[0]);
			mapData.put("lastName", fullName[1]);
		}
		
		LoginDAO dao = new LoginDAO();
		EmpsDTO data = dao.selectLogin(mapData);	//직원 조회
		
		if(data == null) {
			// 조회 결과 없음
			dao.close();
			return false;
		} else {
			// 조회 결과 있음
			List<PermDTO> perm = dao.selectPerm(data.getEmpId());
			System.out.println(perm);
			session.setAttribute("loginData", data);	//직원에대한 정보 세션에 저장
			session.setAttribute("permData", perm);		//직원의 권한 정보 세션에 저장
			dao.close();
			return true;
		}
		
	}

}
