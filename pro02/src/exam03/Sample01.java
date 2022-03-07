package exam03;

import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * 사용자 입력을 받기 위한 Scanner 클래스
		 * 		-콘솔(터미널) 환경에서 사용자 입력을 받기위해 사용.
		 * 		-기본 기능이 아니기 때문에 import 구문이 필요하다. ->import java.util.Scanner;
		 */
		
		//Scanner 객체 생성
		Scanner sc = new Scanner(System.in);
		//new라는 연산자로 새로운 객체 생성
		
		//사용자 입력을 받고 재사용을 위해 변수에 저장.
		System.out.print("이름을 입력하세요. : ");
		String sInput = sc.next();
		
		//사용자 입력 값을 출력
		System.out.println("사용자 입력 값 : " + sInput);
		System.out.printf("사용자 입력 값 : %s\n " , sInput);
	}

}
