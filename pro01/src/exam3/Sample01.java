package exam3;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 *  변수 (Variable) : 값을 저장하기 위한 공간, 변수 공간을 만들때 공간에 대한 이름을 지칭하여 사용(변수명)	
		 *  공간에 저장되는 값은 언제든지 바뀔 수 있다.
		 *  사람 입장에서 값은 정수,실수,문자열 등의 값을 지칭 함
		 *  기계 입장에서 값은 1011001101010 (2진수 - bit값) 이다.
		 *  
		 *  저장된 값은 필요하면 언제든 "재사용" 할 수 있다.
		 *  값이 긴 경우 짧은 변수명으로 사용할 수 있다.
		 *  값이 변경될 경우 변수에 저장될 값만 변경하면 되기 때문에 "유지보수"가 좋아진다.
		 *  
		 *  변수는 메모리(RAM)에 값을 저장하기 때문에 프로그램이 동작하는 동안에만 사용되며, 프로그램이 종료되면
		 *  변수에 저장된 값은 사라진다.
		 */
		
		/*
		 * 세미콜론 ; 의 뜻은 실행할 코드의 끝임을 의미한다.
		 * 
		 * 변수 선언 형식
		 * 			자료형 변수명;  <-얘는 공간만 만든 것
		 * 
		 * 변수 선언 후 즉시 값을 저장하는 형식
		 * 			자료형 변수명 = 값;  <-오른쪽 값을 왼쪽에 저장(할당)
		 * 
		 * 변수 선언 후 나중에 값을 저장하는 형식
		 * 			자료형 변수명;
		 * 			변수명 = 값;
		 */
		
		int n1;
		
		int n2 =1;
		
		int n3;
		n3 = 2;
		
		int n4 = n3 + n2;
		System.out.println(n4);
		
		/*
		 * 자료형 : 변수 공간에 저장할 값의 종류(Type)를 지정하기 위해 사용한다.
		 * 			boolean 논리형 				참, 거짓에 해당하는 논리 값 -> true / false 로 사용한다.
		 * 			char		문자형	문자		문자 값, 문자 값을 저장할 때 반드시 작은따옴표를 사용해야 한다. -> ' '
		 * 			String	문자형	문자열	문자열 값, 문자열 값을 저장할 때 반드시 큰따옴표를 사용해야 한다. -> " "
		 * 			byte		숫자형	정수		정수 값 저장을 위해 사용한다. 단, 타입별로 저장 크기가 다름(1Byte -> 8bit)
		 * 			short	숫자형	정수		정수 값 저장을 위해 사용한다. 단, 타입별로 저장 크기가 다름(2Byte -> 16bit)
		 * 			int		숫자형	정수		정수 값 저장을 위해 사용한다. 단, 타입별로 저장 크기가 다름(4Byte -> 32bit)
		 * 			long		숫자형	정수		정수 값 저장을 위해 사용한다. 단, 타입별로 저장 크기가 다름(8Byte -> 64bit)
		 * 			float		숫자형	실수		실수 값 저장을 위해 사용한다. 단, 타입별로 저장 크기가 다름(4Byte -> 32bit)
		 * 			double	숫자형	실수		실수 값 저장을 위해 사용한다. 단, 타입별로 저장 크기가 다름(8Byte -> 64bit)
		 */
		
		boolean b1 = true;		 //(자바는 소문자로)
		boolean b2 = false;	 //(true, false는 "예약어"라고 한다.)
		
		char c1 = 'a';
		String s1 = "a";
		
		byte b3 = 1;
		short s2 = 2;
		int i1 = 3;				//기본적으로 정수타입은 int를 많이 쓴다.
		long l1 = 4;			//l을 안붙여도 된다.
		
		float f1 = 5.0f;		//float은 반드시 값 뒤에 f를 써야 한다.
		double d1 = 6.0;		//기본적으로 실수타입은 double를 많이 쓴다.
		
		// 리터럴(literal) : 변수에 대입되는 값 자체
		
		
	}

}
