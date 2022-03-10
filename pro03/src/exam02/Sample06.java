package exam02;

import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		/*
		 * 사용자가 입력한 정수값 까지 반복 출력하는 코드를 작성한다.
		 * (1 ~ 사용자 입력 값 까지 출력)
		 */
		
		/*
		 * for(int i = 0; i < num; i++) {
				System.out.println(i+1);
			}
		 */
		
		
		
		/*
		 * 사용자가 입력한 정수값 부터 ~ 1 까지 반복 출력하는 코드를 작성한다.
		 */
		
		/*for(int i = num; i >= 1; i--) {
		*	System.out.println(i);
		*}
		*/
		
		
		
		/*
		 * 위 문제에서 반복 출력할 때 한 줄에 7개의 정수 값이 출력되도록 작성한다.
		 */
		
		int num;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사용자 입력 값 : ");
		num = sc.nextInt();
		
		for(int i = 1; i < num+1; i++) {
			System.out.println(i);
		}
		
		
		System.out.print("사용자 입력 값 : ");
		num = sc.nextInt();
		
		for(int i = num; i >= 1; i--) {
			System.out.println(i);
		}
		
		
//		int cnt = 0; //7개를 출력했는지 아닌지 구별하기위한 정수값 //flag
		System.out.print("사용자 입력 값 : ");
		num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			System.out.print(i + 1 + " ");
//			cnt++;
			if((i + 1) % 7 == 0) {
				System.out.println();
			}
//			if(cnt == 7) { //cnt % 7 == 0
//				System.out.println();
//				cnt = 0; //생략가능
//			}
		}

	}

}
