package exam01;

public class Sample01 {
	
	/*
	 * 프로그램 오류와 예외 클래스
	 * 
	 * 1.컴파일 에러(compile-time error) : 컴파일 할 때 발생하는 에러
	 * 2.런타임 에러(runtime error) : 실행 할 때 발생하는 에러 (프로그램 종료됨)
	 * 		-에러(error) : 프로그램 코드에 의해서 수습될 수 없는 심각한 오류
	 * 		-예외(exception) :  프로그램 코드에 의해서 수습될 수 있는 다소 미약한 오류
	 * 3.논리적 에러(logical error) : 작성 의도와 다르게 동작 (프로그램이 종료되는건 아님)
	 * 
	 * 예외처리의 정의와 목적
	 * 	정의 : 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것
	 * 	목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것
	 * 
	 * 예외 클래스의 계층 구조 (1번 부터 최고 조상순이다)
	 * 	1. 최고 조상 : object
	 * 	2. Throwable : 클래스. 모든 오류의 조상.
	 * 	3.	- Error : 심각한 오류 (런타임 에러) (자손들 OutOfMemoryError(메모리 부족)... 등)
	 * 		- Exception :미약한 오류 (런타임 에러) (자손들 RuntimeException, IOException... 등)
	 * 	4.RuntimeException의 자손들
	 * 		-ArihmeticException
	 * 		-ClassCastException
	 * 		-NullPointException
	 * 		-IndexOutOfBoundException
	 * 		-....등
	 * 
	 * Exception클래스들(+자손 클래스) : 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외
	 * RuntimException클래스들(+자손 클래스) : 프로그래머의 실수로 발생하는 예외
	 */

	public static void main(String[] args)  {
		MyException m = new MyException();
		System.out.println("에러 발생 전");
//		try {
//			m.exceptionThrows();
//		} catch (Exception e) {
//			System.out.println("에러 처리함");
//		}
		m.exceptionNonThrows();
		System.out.println("에러 발생 후");

	}

}
