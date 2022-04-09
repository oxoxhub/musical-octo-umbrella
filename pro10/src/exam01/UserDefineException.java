package exam01;

//사용자 정의 예외 처리 만들기
public class UserDefineException extends Exception {
	
	public UserDefineException() {}		// 생성자
	public UserDefineException(String message) { 
		super(message);		// 생성자
	}

}
