package exam02;

import java.util.Random;
import java.util.Scanner;

public class Sample15 {

	public static void main(String[] args) {
		/*
		 * 1부터 100 사이의 정수 중 임의의 난수가 정해지고 사용자는 정해진 난수를 맞추는데
		 * 몇 번 만에 맞췄는지 출력하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		int input;
		
		int num = random.nextInt(100) +1; // 0 ~ 100 사이의 난수값 생성
		
		for(int i =1; ; i++) {
			
			System.out.print("1 ~ 100사이의 임의의 난수를 맞춰보세요. : ");
			input = sc.nextInt();
			
			if(input >= 1 && input <= 100) {
				if(input != num) {
					if(input < num) {
						System.out.println("up!");
					} else if(input > num) {
						System.out.println("down!");
					}
				}else {
					System.out.println("정답입니다!!");
					System.out.printf("%d회만에 맞추셨습니다.", i);
					break;
				}
			} else {
				System.out.println("1 ~ 100사이의 숫자를 입력해주세요.");
			}
			
			
		}
		
		
		
	}
		
}
