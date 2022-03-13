package exam02;

import java.util.Random;
import java.util.Scanner;

public class Sample16 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		
		int win=0, draw=0, lose=0;
		
		for(int i = 0; ; i++) {
			
			int com = random.nextInt(3)+1;
			
			System.out.print("가위바위보 : ");
			String user = sc.nextLine();
			

			if(user.equals("가위")) {
				if(com == 1) {
					System.out.println("컴퓨터 : 가위");
					System.out.printf("%s : %s\n", name, "가위");
					System.out.println("비겼습니다.");
					draw++;
				} else if(com == 2) {
					System.out.println("컴퓨터 : 바위");
					System.out.printf("%s : %s\n", name, "가위");
					System.out.println("졌습니다.");
					lose++;
				} else if(com == 3) {
					System.out.println("컴퓨터 : 보");
					System.out.printf("%s : %s\n", name, "가위");
					System.out.println("이겼습니다.");
					win++;
				} 
			} else if(user.equals("바위")) {
				if(com == 1) {
					System.out.println("컴퓨터 : 가위");
					System.out.printf("%s : %s\n", name, "바위");
					System.out.println("이겼습니다.");
					win++;
				} else if(com == 2) {
					System.out.println("컴퓨터 : 바위");
					System.out.printf("%s : %s\n", name, "바위");
					System.out.println("비겼습니다.");
					draw++;
				} else if(com == 3) {
					System.out.println("컴퓨터 : 보");
					System.out.printf("%s : %s\n", name, "바위");
					System.out.println("졌습니다.");
					lose++;
				}
			} else if(user.equals("보")) {
				if(com == 1) {
					System.out.println("컴퓨터 : 가위");
					System.out.printf("%s : %s\n", name, "보");
					System.out.println("졌습니다.");
					lose++;
				} else if(com == 2) {
					System.out.println("컴퓨터 : 바위");
					System.out.printf("%s : %s\n", name, "보");
					System.out.println("이겼습니다.");
					win++;
				} else if(com == 3) {
					System.out.println("컴퓨터 : 보");
					System.out.printf("%s : %s\n", name, "보");
					System.out.println("비겼습니다.");
					draw++;
				}
			} else if(user.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패", i, win, draw, lose);
				break;
			} else {
				i--;
				System.out.println("잘못 입력하셨습니다.");
			}
			
			System.out.println();
		}
	}

}
