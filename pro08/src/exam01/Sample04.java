package exam01;

import java.util.StringTokenizer;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * StringTokenizer
		 *     - String 클래스에서 제공하는 split() 메서드와 유사한 기능을 제공하는 클래스
		 */
		String phone = "010-1234-5678";
		StringTokenizer token = new StringTokenizer(phone, "-");
		
		//countTokens : nextToken()으로 분리할 수 있는 토큰의 수를 반환
		//				StringTokenizer객체 안에 담겨있는 토큰들의 개수를 반환해주는 메서드
		System.out.println("토큰 수 : " + token.countTokens());
		
		//배열에 담는 것을 생략한다.
		//hasMoreTokens : 분리할 수 있는 토큰의 존재 유무를 boolean형으로 반환
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken());	//nextToken : 분리된 토큰을 반환
		}
	}

}
