package exam02;

public class Sample01 {

	public static void main(String[] args) {
		
		/* 메모리RAM 구조:
		*
		*	Static 영역 : static 예약어로 선정된 필드. 메소드가 저장되는 공간. 클래스 변수 등
		*	HEAP 영역 : new연산자에 의해 동적으로 할당하고 저장되는 공간. 객체,배열 등
		*	STACK 영역 : 메소드를 호출하면 자동생성 메소드 끝나면 자동 소멸. 지역변수, 매개변수, 메소드 호출 스택 등
		*
		*	참조값은 STACK에 저장
		*	참조값의 값은 HEAP에 저장
		*
		*	GC (garbage collector) : 사용하지 않는 메모리 공간을 수집하여 소멸
		*
		*	System.out.print()
		*	System.out.println() : 줄바꿈을 해주는 메소드
		*/
		
		System.out.print("안녕하세요.");
		System.out.print("반갑습니다.");
		System.out.print("제 이름은 홍길동 입니다.");
		/*안녕하세요.반갑습니다.제 이름은 홍길동 입니다.
		 *줄바꿈 명령어가 없어서 그대로 출력된다.
		 *마지막에 한 줄이 없다.
		 */
		
		System.out.println("안녕하세요.");
		System.out.println("반갑습니다.");
		System.out.println("제 이름은 홍길동 입니다.");
		//줄바꿈 = 개행
		//출력하고 개행을 해서 마지막에 한줄이 더 있다.
		
		//출력 형식을 지정하는 메서드
		int i1 = 30;
		System.out.println("당신의 나이는 " + i1 + " 세 입니다."); 	// 정수
		System.out.printf("당신의 나이는 %d 세 입니다.\n", i1 );
		System.out.printf("당신의 나이는 %o 세 입니다.\n", i1 );		//8진수
		System.out.printf("당신의 나이는 %x 세 입니다.\n", i1 ); 	//16진수
		System.out.printf("당신의 나이는 %c 세 입니다.\n", i1 ); 	//아스키 코드
		System.out.printf("당신의 나이는 %c 세 입니다.\n", i1+3 ); 	//아스키 코드
		
		double d1 = 1234.5678;
		System.out.printf("실수 표기 형식 : %f\n", d1);	//실수(소수점 아래 6자리)
		System.out.printf("실수 표기 형식 : %.2f\n", d1);	//실수 소수점 원하는 자리수까지 출력
		System.out.printf("실수 표기 형식 : %.3f\n", d1);
		System.out.printf("실수 표기 형식 : %.10f\n", d1);
		System.out.printf("실수 표기 형식 : %e\n", d1);	//지수형태표현
		System.out.printf("실수 표기 형식 : %g\n", d1);	//대입 값 그대로
		System.out.printf("실수 표기 형식 : %A\n", d1);	//16진수 실수
		
	}

}
