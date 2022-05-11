package com.join.controller;

import com.join.dao.JoinDAO;
import com.join.vo.JoinVO;

public class JoinController {
	
	private JoinDAO dao = new JoinDAO();
	
	public boolean join(JoinVO data) {
		//회원가입 처리 전 필요한 로직(데이터 검사, 계산 등).
		//회원가입 처리 후 결과를 반환한다.
		
		
		//가입을 진행하기 전에 아이디 중복 확인!
		
		JoinVO account = dao.get(data.getUserid());
		
		if(account == null) { 		// 입력한 아이디가 중복이 없다면 null 가입 진행
			boolean result = dao.add(data);		// 사용자가 처음에 입력한 정보로 쿼리에 데이터 추가
			if(result) {	// result가 true일시 데이터 추가 성공
				return true;
			}
		}
		return false;	// 아이디 중복으로 데이터 추가 실패.
	}
	
	public JoinVO login(String userid, String userpw) {
		// 로그인시 userid 에 해당하는 계정이 있는지 확인.
		
		JoinVO account = dao.get(userid); //해당하는 계정이 있다면 회원정보가 담긴(JoinVo) 객체 주소 반환 받아 저장 
		
		//해당 계정이 userpw의 값과 동일한 패스워드를 가지고 있는지 확인 후
		//동일한 정보면 사용자 정보 객체(JoinVO) 전달 아니면 null 전달
		
		if(account != null) {	// null값이 아니라면 회원 가입한 아이디가 있다는 것
			if(account.getUserpw().equals(userpw)) {	
				return account;		// account는 매개변수로 받은 아이디의 회원정보가 담긴 객체의 주소
			}
		} 
		return null;	// 회원 가입 된 아이디가 없다.
		
	}


}
