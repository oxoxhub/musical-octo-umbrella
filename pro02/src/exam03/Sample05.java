package exam03;

import java.util.Scanner;

public class Sample05 {

	public static void main(String[] args) {
		System.out.print("현재 월을 입력하세요.>");
		
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();  // 화면을 통해 입력받은 숫자를 month에 저장

		if (month==3) {
				System.out.println("현재의 계절은 봄입니다.");
		}
		else if (month==6) {
				System.out.println("현재의 계절은 여름입니다.");
		}
		else if (month==9) {
				System.out.println("현재의 계절은 가을입니다.");	
		} else {
				System.out.println("현재의 계절은 겨울입니다.");
		}
	}

}
