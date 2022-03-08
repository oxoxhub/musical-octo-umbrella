package exam04;

import java.util.Scanner;

public class Sample02 {

	//이항 연산자  : 피연산자가 2개 있는 연산
	//1+1, 1*2, ...
	public static void main(String[] args) {
		// 산술 연산자
		// +, -, *, /(나누기), %(나머지)
		int num1, num2;
		
		num1 = 10;	//Scanner 사용해서 사용자 입력을 받는 것으로 변경.
		num2 = 3;	//Scanner 사용해서 사용자 입력을 받는 것으로 변경.
		
		Scanner sc = new Scanner(System.in);
		System.out.print("첫 번째 입력 값 : ");
//		num1 =sc.nextInt();
				
		System.out.print("두 번째 입력 값 : ");
//		num2 =sc.nextInt();	
		
		System.out.printf("%d + %d = %d\n", num1, num2, num1 + num2);
		System.out.printf("%d - %d = %d\n", num1, num2, num1 - num2);
		System.out.printf("%d * %d = %d\n", num1, num2, num1 * num2);
		System.out.printf("%d / %d = %d\n", num1, num2, num1 / num2);
		System.out.printf("%d / %d = %f\n", num1, num2, (double)num1 / num2); //강제 형변환
		System.out.printf("%d %% %d = %d\n", num1, num2, num1 % num2);
		//나머지 연산자는 %%를 두번 써줘야한다.
		
		// 비교 연산자
		// ==(같다), !=(다르다), <(왼쪽 피연산자가 작다), >(왼쪽 피연산자가 크다), 
		// <=(왼쪽 피연산자가 작거나 같다), >=(왼쪽 피연산자가 크거나 같다)
		
//		num2 =10; //Scanner 사용해서 사용자 입력을 받는 것으로 변경.
		System.out.printf("%d == %d -> %b\n", num1, num2, num1 == num2);
		System.out.printf("%d != %d -> %b\n", num1, num2, num1 != num2);
		System.out.printf("%d > %d -> %b\n", num1, num2, num1 > num2);
		System.out.printf("%d < %d -> %b\n", num1, num2, num1 < num2);
		System.out.printf("%d >= %d -> %b\n", num1, num2, num1 >= num2);
		System.out.printf("%d <= %d -> %b\n", num1, num2, num1 <= num2);
		
		//논리 연산자
		//		&& : and 논리 연산 기호, 두 피연산자의 논리값이 전부 참인 경우에만 참으로 연산하는 연산자
		//		|| : or 논리 연산 기호, 두 피연산자의 논리값이 전부 거짓인 경우에만 거짓으로 연산하는 연산자
		//논리 연산은 true, false 논리 값으로만 연산을 수행한다.
		
		System.out.printf("%b %% %b -> %b\n", true, true, true && true);
		System.out.printf("%b %% %b -> %b\n", true, false, true && false);
		System.out.printf("%b %% %b -> %b\n", false, true, false && true);
		System.out.printf("%b %% %b -> %b\n", false, false, false && false);
		//false가 하나라도 있으면 and 논리 연산은 거짓이 된다.
		
		System.out.printf("%b || %b -> %b\n", true, true, true || true);
		System.out.printf("%b || %b -> %b\n", true, false, true || false);
		System.out.printf("%b || %b -> %b\n", false, true, false || true);
		System.out.printf("%b || %b -> %b\n", false, false, false || false);
		//하나라도 true가 있다면 or 논리 연산은 참이 된다.
		
	}

}









