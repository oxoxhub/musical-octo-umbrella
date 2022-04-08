package exam01;

//사용자 정의 예외 처리 만들기
public class UserDefineException extends Exception {
	public UserDefineException() {}
	public UserDefineException(String message) {
		super(message);
	}

}
