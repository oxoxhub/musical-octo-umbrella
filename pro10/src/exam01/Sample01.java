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
	 * 예외처리(exception handling)의 정의와 목적
	 * 	정의 : 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것
	 * 	목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것
	 * 
	 * 예외 클래스의 계층 구조 (1번 부터 최고 조상순이다)
	 * 	1. 최고 조상 : object
	 * 		ㄴ 2. Throwable : 클래스. 모든 오류의 조상.
	 * 		ㄴ 3. - Error : 심각한 오류 (런타임 에러) (자손들 OutOfMemoryError(메모리 부족)... 등)
	 * 				 - Exception :미약한 오류 (런타임 에러) (자손들 RuntimeException, IOException... 등) <-이걸 대비하는 것이 예외처리이다.
	 * 		ㄴ 4.RuntimeException의 자손들 (Exception의 자손 클래스이다.)
	 * 				-ArihmeticException
	 * 				-ClassCastException
	 * 				-NullPointException
	 * 				-IndexOutOfBoundException
	 * 				-....등
	 * 
	 * Exception클래스 (+자손 클래스) : 사용자의 실수와 같은 외적인 요인에 의해 발생하는 예외 (Checked Exception)
	 * 	ㄴIOException (자손 클래스) : 입출력 예외. (외적인 요인) (Checked Exception)
	 * 	ㄴClassNotFoundException (자손 클래스) : 클래스 파일을 찾을 수 없음. (외적인 요인) (Checked Exception)
	 * 	ㄴRuntimException클래스 (+자손 클래스) : 프로그래머의 실수로 발생하는 예외 (Unchecked Exception)
	 * 	 	ㄴArihmeticException (자손 클래스) : 산술계산예외. 0으로 나누기.
	 * 		ㄴClassCastException (자손 클래스) : 형변환 오류.
	 * 		ㄴNullPointException (자손 클래스) : 참조변수가 가르키는 객체가 null 일 때.
	 * 		ㄴIndexOutOfBoundException (자손 클래스) : 배열 범위 범어나는 오류.
	 * 		ㄴNegativeArraySizeException (자손 클래스) : 배열 크기를 음수로 지정한 경우 발생 배열 크기를 0보다 크게 지정해야한다.
	 * 
	 * Checked예외 : 컴파일러가 예외 처리 여부를 체크 (예외 처리 필수. try~catch 필수)
	 * Unchecked예외 : 컴파일러가 예외 처리 여부를 체크 안함 (예외 처리 선택.  try~catch 선택사항)
	 * 
	 * 예외처리 방법
	 * 	1. Exception 처리를 호출한 메소드에게 위임 
	 * 		메소드 선언 시 throws ExceptionName문을 추가하여
	 * 		호출한 상위 메소드에게 처리 위임.
	 * 		계속 위임하면 main()메소드까지 위임하게 되고 거기서도 처리되지 않으면 비정상 종료된다.
	 * 	2. Exception이 발생한 곳에서 직접 처리
	 * 		try~catch문을 이용하여 예외처리한다.
	 * 
	 * 		try {		// 괄호 생략 불가
	 * 				//예외가 발생할 가능성이 있는 문장들을 넣는다.
	 * 		}	catch (Exception e1) {
	 * 				//Exception1이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
	 * 		}	catch (Exception e2) {
	 * 				//Exception2이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
	 * 		}	catch (Exception eN) {
	 * 				//ExceptionN이 발생했을 경우, 이를 처리하기 위한 문장을 적는다.
	 * 		}
	 * 	
	 * 
	 */

	public static void main(String[] args)  {
		
		MyException m = new MyException();
		
		System.out.println("에러 발생 전");
		
		try {
			m.exceptionThrows();
		} catch (Exception e) {
			System.out.println("에러 처리함");
		}
		
//		m.exceptionNonThrows();
		
		System.out.println("에러 발생 후");

	}

}
