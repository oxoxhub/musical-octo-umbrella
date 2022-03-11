package exam02;

import java.util.Scanner;

public class Sample11 {

	public static void main(String[] args) {
		/* 
		 * 2. 사용자가 입력한 영단어에서 'a', 'e', 'i', 'o', 'u' 문자의 수를 구해 출력한다.
		 * "java programming" -> 5 개.
		 * 
		 * 3. 사용자 입력한 영단어에서 대문자/소문자의 수를 구해서 출력한다.
		 * "java programming" -> 대문자 2개, 소문자 13개
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자열 입력 : ");
		String input = sc.nextLine();
		
		int cnt = 0;
		for(int i = 0; i < input.length(); i++) {
			switch(input.charAt(i)) {
				case 'a' : 	case 'e' :	case 'i' :	case 'o' :	case 'u' :
					cnt++;
			}
//			if(input.charAt(i) == 'a') {
//				cnt++;
//			} else if(input.charAt(i) == 'e') {
//				cnt++;
//			} else if(input.charAt(i) == 'i') {
//				cnt++;
//			} else if(input.charAt(i) == 'o') {
//				cnt++;
//			} else if(input.charAt(i) == 'u') {
//				cnt++;
//			}
		}
		System.out.printf("'a', 'e', 'i', 'o', 'u' 문자가 총 %d 개 있습니다.", cnt);

	}

}
