package exam3;

public class Sample02 {

	public static void main(String[] args) {
		//지역변수는 반드시 초기화가 필요.
		int x;
		//System.out.println(x);
		//공간만 만들고 값이 없기때문에 8번째줄은 에러가 난다
		
		x =1;
		System.out.println(x);
		
		//멤버 변수는 초기화를 하지 않아도 된다. 자동으로 기본 값이 할당되기때문에.
		/* 상수 : 한 번 초기화를 한 후에는 값을 변경할 수 없다.
		 * 변수 선언 방식과 유사하며, 변수 선언 할 때 쓰이는 자료형 앞에 final 예약어를 쓰면 된다.
		 * 변하지 않는 값 의미, 한 번만 저장 할 수있는 메모리 의미
		 */
		final int i1;
		i1 = 2;
		//i1 = 3;
		//21째줄은 The final local variable i1 may already have been assigned 에러가 난다.
		
		final int i2 = 3;
		
		/*
		 * 문자열
		 * 다른 자료형 + "문자열" -> 문자열
		 * 	String str1 = "기차" + 123 + 45 + "출발";
		 * "기차123" + 45 + "출발"
		 * 	"기차12345" + "출발"
		 * 	"기차12345출발"
		 * 
		 * "문자열" + 다른 자료형 -> 문자열
		 * String str2 = 123 + 45 + "기차" + "출발";
		 */
		
		String str1 = "기차" + 123 + 45 + "출발";
		String str2 = 123 + 45 + "기차" + "출발";
		String str3 = "기차" + (123 + 45) + "출발";
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
	}

}
