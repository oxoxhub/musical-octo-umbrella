package com.join.view;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.join.controller.JoinController;
import com.join.dao.JoinDAO;
import com.join.menu.JoinMenu;
import com.join.vo.JoinVO;

/*
 * CLI 화면에 회원가입, 탈퇴, 정보수정 등과 같은 메뉴 및 정보를
 * 보여주고 사용자가 데이터를 입력할 수 있는 화면을 제공하는 객체
 */

public class JoinView {
	
	private Scanner sc = new Scanner(System.in);
	private JoinController jc = new JoinController();
	private JoinMenu menu = new JoinMenu();
			
	
	public void show() {
		// 회원 가입 및 로그인 요청에 맞추어 적절한 메서드를 호출
		while(true) {
			System.out.print(menu.getMain());
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			switch(input) {
				case "1":
					this.joinMenu();	break;
				case "2":
					this.loginMenu();	break;
				case "3":
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
		
		JoinVO account = jc.login(userid, userpw);
		
		if(account != null) {
			System.out.println(account.getUserid() + "님이 로그인 하였습니다.");
			this.afterLoginMenu(account);
		} else {
			System.out.println("잘못된 아이디 또는 패스워드 입니다.");
		}
		
	}
	
	public void afterLoginMenu(JoinVO account) {
		
		while(true) {
			System.out.print(menu.getAfterLogin(account.getUserid()));
			System.out.print(">>> ");
			String input = sc.nextLine();
			
			switch(input) {
				case "1" :
					System.out.println(account.getUserid());
					System.out.println(account.getUsername());
					System.out.println(account.getGender());
					System.out.println(account.getAge());
					
					System.out.println(account.getCreateDate());
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
					
					java.util.Date createDate = new java.util.Date(account.getCreateDate().getTime());
					String sDate = dateFormat.format(createDate);
					
					System.out.println(sDate);
					
					java.util.Date now = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(now.getTime());
					sqlDate = java.sql.Date.valueOf("2022-05-13");
					
					System.out.println(sqlDate);
					
					break;
					
				case "2" :
					System.out.println("아무것도 입력을 하지 않으면 이전 값을 유지 합니다.");
					System.out.print("수정할 비밀번호를 입력 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? account.getUserpw() : input;
					account.setUserpw(input);
					
					System.out.print("수정할 이름을 입력 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? account.getUsername() : input;
					account.setUsername(input);
					
					System.out.print("수정할 성별을 입력(남/여) : ");
					input = sc.nextLine();
					input = input.isEmpty() ? Character.toString(account.getGender())  : input;
					account.setGender(input);
					
					System.out.print("수정할 나이를 입력 : ");
					input = sc.nextLine();
					input = input.isEmpty() ? Integer.toString(account.getAge()) : input;
					account.setAge(input);
					
					if(jc.update(account)) {
						System.out.println("정보 수정이 완료되었습니다.");
					} else {
						System.out.println("정보 수정에 실패했습니다.");
					}
					
					break;
					
				case "3" :
					
					System.out.print("패스워드 : ");
					input = sc.nextLine();
					
					if(jc.remove(account, input)) {
						System.out.println("계정이 삭제되었습니다.");
						return;
					} else {
						System.out.println("계정 삭제를 실패했습니다.");
					}
					
					break;
					
				case "4" :
					account = null;
					return;
					
				default :
					System.out.println("잘못된 메뉴 번호 입니다. 다시 입력하세요.");
			}
		}
	}

}


