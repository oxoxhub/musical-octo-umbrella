package exception;

//RuntimeException은 try-catch문 선택사항이다.
public class GradeException extends RuntimeException {

	public GradeException() {
		super();
	}

	public GradeException(String message) {
		super(message);
	}



}
