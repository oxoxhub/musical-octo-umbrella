package com.join.menu;

public class JoinMenu {
	
	public String getMain() {
		String s = ""
				+ "<<<< 회원가입 프로그램 >>>>\n"
				+ "┌─────────────────────────┐\n"
				+ "│ 1. 회원 가입            │\n"
				+ "│ 2. 로그인               │\n"
				+ "│ 3. 프로그램 종료        │\n"
				+ "└─────────────────────────┘\n";
		return s;
	}
	
	public String getAfterLogin(String userid) {
		String s =""
				+ "<<<< " + userid + "님 환영합니다. >>>>\n"
				+ "┌─────────────────────────┐\n"
				+ "│ 1. 정보 출력            │\n"
				+ "│ 2. 정보 수정            │\n"
				+ "│ 3. 회원 탈퇴            │\n"
				+ "│ 4. 로그 아웃            │\n"
				+ "└─────────────────────────┘\n";
		return s;
	}
}
