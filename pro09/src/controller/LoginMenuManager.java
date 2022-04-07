package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.vo.Account;
import model.vo.Student;
import model.vo.Teacher;

public class LoginMenuManager {

	private TeacherDatabaseManager tDB = new TeacherDatabaseManager();
	private DatabaseManager sDB = new DatabaseManager();
	private Scanner sc = new Scanner(System.in);
	
	public void main() {
		StringBuilder sb = new StringBuilder();
		sb.append("1. 교사용 로그인\n");
		sb.append("2. 학생용 로그인\n");
		sb.append("3. 비밀번호 초기화\n");
		sb.append("9. 프로그램 종료\n");
		sb.append(">>> ");
		
		while(true) {
			System.out.print(sb.toString());
			String menuNumber = sc.nextLine();
			switch(menuNumber.charAt(0)) {
				case '1':
					teacherLoginMenu();	break;
				case '2':
					studentLoginMenu();	break;
				case '3':
					resetPassword(); break;
				case '9':
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
			}
		}
	}

	private void teacherLoginMenu() {
		System.out.print("이름 : ");
		String username = sc.nextLine();
		
		for(int i = 0; i < 3; i++) {
			System.out.print("패스워드 : ");
			String password = sc.nextLine();
			
			//선생님을 관리하는 객체 tDB의 login 메서드에 매개변수 username, password 넘겨주기
			//tDB.login은 매개변수를 받고 실행되어 로그인 정보가 맞는 Teacher 객체의 참조변수를 반환한다.
//			Account loginAccount = tDB.login(username, password);
			Teacher loginAccount = tDB.login(username, password);
			
			if(loginAccount != null) {
				System.out.println("최근 접속 시간 : " + ((Teacher)loginAccount).getLoginDateFormat());
				
				loginAccount.setLoginDate(new Date());
				
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
				System.out.println("현재 접속 시간 : " + sFormat.format(new Date()));
				
				MenuManager m = new MenuManager(loginAccount);
				m.main();
				break;
			} else {
				System.out.println("로그인 실패. 패스워드를 다시 입력하세요.");
			}
		}
		
	}

	private void studentLoginMenu() {
		System.out.print("이름 : ");
		String username = sc.nextLine();
		
		for(int i = 0; i < 3; i++) {
			System.out.print("패스워드 : ");
			String password = sc.nextLine();
			
			Account loginAccount = sDB.login(username, password);
			
			if(loginAccount != null) {
				MenuManager m = new MenuManager(loginAccount);
				m.main();
				break;
			} else {
				System.out.println("로그인 실패. 패스워드를 다시 입력하세요.");
			}
		}
	}
	
	private void resetPassword() {
		StringBuilder sb = new StringBuilder();
		sb.append("1. 교사용 로그인 비밀번호 초기화\n");
		sb.append("2. 학생용 로그인 비밀번호 초기화\n");
		sb.append(">>> ");
		
		System.out.print(sb.toString());
		String menuNumber = sc.nextLine();
		
		switch(menuNumber.charAt(0)) {
			case '1':
				teacherResetPassword();	break;
			case '2':
				studentResetPassword();	break;
		}
	}
		
	private void teacherResetPassword() {
		System.out.print("이름 : ");
		String username = sc.nextLine();
		
		boolean existed = tDB.isExisted(username);
		if(existed) {
			Account loginAccount = tDB.getTeacher(username);
			loginAccount.ResetPassword();
			String newPass = loginAccount.getPassword();
			System.out.println("초기화된 비밀번호 : " + newPass);
			System.out.println("비밀번호가 초기화되었습니다.");
		} else {
			System.out.println("해당하는 계정이 존재하지 않습니다.");
		}
	}
	
	private void studentResetPassword() {
		System.out.print("이름 : ");
		String username = sc.nextLine();
		
		boolean existed = tDB.isExisted(username);
		if(existed) {
			Account loginAccount = sDB.getStudent(username);
			loginAccount.ResetPassword();
			String newPass = loginAccount.getPassword();
			System.out.println("초기화된 비밀번호 : " + newPass);
			System.out.println("비밀번호가 초기화되었습니다.");
		} else {
			System.out.println("해당하는 계정이 존재하지 않습니다.");
		}
	}
	
}
