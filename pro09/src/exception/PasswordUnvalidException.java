package exception;

//RuntimeException은 try-catch문 선택사항이다.
public class PasswordUnvalidException extends RuntimeException {

	public PasswordUnvalidException() {
		super();
	}

	public PasswordUnvalidException(String message) {
		super(message);
	}

}
