package com.join.view;

import java.util.Scanner;

import com.join.controller.JoinController;
import com.join.dao.JoinDAO;
import com.join.vo.JoinVO;

/*
 * CLI 화면에 회원가입, 탈퇴, 정보수정 등과 같은 메뉴 및 정보를
 * 보여주고 사용자가 데이터를 입력할 수 있는 화면을 제공하는 객체
 */

public class JoinView {
	
	private Scanner sc = new Scanner(System.in);
	private JoinController jc = new JoinController();
	private JoinDAO dao = new JoinDAO();
	private JoinVO account = new JoinVO();
			
	
	public void show() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("    회원가입 프로그램    \n");
		sb.append("-------------------------\n");
		sb.append("  1. 회원 가입\n");
		sb.append("  2. 로그인\n");
		sb.append("  3. 프로그램 종료\n");
		sb.append("-------------------------\n");
		sb.append(">>> ");
		
		//회원 가입 및 로그인 요청에 맞추어 적절한 메서드를 호출
		while(true) {
			System.out.print(sb.toString());
			String input = sc.nextLine();
			
			switch(input) {
				case "1" :
					this.joinMenu();	break;
				case "2" : 
					this.loginMenu(); 	break;
				case "3" :
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				default:
					System.out.println("잘못된 메뉴 번호 입니다. 다시 입력하세요.");
			}
		}
	}
	
	public void joinMenu() {
		//회원가입을 처리하기 위한 메서드
		
		JoinVO data = new JoinVO();
		
		System.out.print("id 를 입력하세요 : ");
		data.setUserid(sc.nextLine());
		
		System.out.print("password 를 입력하세요 : ");
		data.setUserpw(sc.nextLine()); 
		
		System.out.print("이름을 입력하세요 : ");
		data.setUsername(sc.nextLine());
		
		System.out.print("성별을 입력하세요 ('남' or '여'): ");
		data.setGender(sc.nextLine()); 
		
		System.out.print("나이를 입력하세요 : ");
		data.setAge(sc.nextLine()); 
		
		boolean result = jc.join(data);
		//true 반환시 데이터 추가 성공. 반대는 false
		
		if(result) {
			System.out.println("회원 가입이 완료되었습니다.");
		} else {
			System.out.println("회원 가입에 실패하였습니다.(아이디 중복)");
		}
		
	}
	
	public void loginMenu() {
		//로그인을 처리하기 위한 메서드
		
		System.out.print("id : ");
		String userid = sc.nextLine();
		
		System.out.print("password : ");
		String userpw = sc.nextLine();
		
		this.account = jc.login(userid, userpw);
		
		if(account != null) {
			System.out.println(account.getUserid() + "님이 로그인 하였습니다.");
			loginMenu2();
		} else {
			System.out.println("잘못된 아이디 또는 패스워드 입니다.");
		}
		
	}
	
	public void loginMenu2() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("-------------------------\n");
		sb.append("1.정보수정\n");
		sb.append("2.회원 탈퇴\n");
		sb.append("3.로그아웃\n");
		sb.append("-------------------------\n");
		sb.append(">>> ");
		
		boolean logout = false;
		while(true) {
			System.out.print(sb.toString());
			String input = sc.nextLine();
			System.out.println();
			
			switch(input) {
				case "1" :
					this.update();	break;
				case "2" :
					boolean result = this.delete();	
					if(result) {
						logout = true;
					}
					//break;
				case "3" :
					logout = true;
			}
			if(logout) {
				break;
			}
		}
	}
	
	public void update() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		sb.append("-------------------------\n");
		sb.append("수정할 정보를 선택하세요.\n");
		sb.append("1.비밀번호\n");
		sb.append("2.이름\n");
		sb.append("3.성별\n");
		sb.append("4.나이\n");
		sb.append("5.메인메뉴로 돌아가기\n");
		sb.append("-------------------------\n");
		sb.append(">>> ");
		
		boolean menuBack = false;
		while(true) {
			System.out.print(sb.toString());
			String input = sc.nextLine();
			System.out.println();
			
			switch(input) {
				case "1" :
					System.out.print("수정할 비밀번호를 입력 : ");
					String pw = sc.nextLine();
					
					boolean result = dao.modify(pw, account.getUserid());
					if(result) {
						System.out.println("비밀번호가 수정되었습니다.");
						break;
					} else {
						System.out.println("비밀번호 수정을 실패했습니다.");
						break;
					}
					
				case "5" :
					menuBack = true;
			}
			if(menuBack) {
				break;
			}
		}
		
	}
	
	public boolean delete() {
		boolean result = dao.remove(account.getUserid());
		if(result) {
			System.out.println("계정이 삭제되었습니다.");
			return true;
		} else {
			System.out.println("계정 삭제를 실패했습니다.");
			return false;
		}
	}
	

}



