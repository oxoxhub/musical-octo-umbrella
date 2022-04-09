package exam01;

public class MyException {
	
		//throws UserDefineException라는 예외가 발생할 수 있다라고 알려준다.
		//exceptionRun메서드에서 예외 발생하였고 떠넘기기 당하여 이 메서드에 다시 왔으나
		//try-catch문이 없어서 또 자신을 호출한 메서드인 메인메서드로 예외 떠넘기기를 한다.
		//메인 메서드 95~99번째 줄에 try-catch문이 있어서 예외처리를 한다.
		public void exceptionThrows() throws UserDefineException{
			exceptionRun();
		}
		
		public void exceptionNonThrows() {
			try {
				//예외가 발생하면 발생한 예외에 해당하는 클래스의 인스턴스가 만들어진다.
				//예외가 발생한 문장이 try블럭에 포함되어 있다면, 이를 처리할 수 있는 catch블럭이 있는지 찾게 된다.
				exceptionRun();	//여기서 에러가 없으면 catch문 실행되지 않고 건너뛴다.
			} catch(UserDefineException e) {
				System.out.println("에러 처리함.");
				// printStackTrace() : 예외발생 당시의 호출스책에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다.
				e.printStackTrace();	
			}
		}
		
		private void exceptionRun() throws UserDefineException{
			
			//발생시키려는 예외 클래스의 객체를 new연산자를 통해 만든다음 예외를 강제로 발생시킴(throw)
			throw new UserDefineException("사용자 정의 예외 에러가 발생하였습니다.");
			//이후 throws로 인해 예외 떠넘기기가 된다. 그래서 자신을 호출한 메서드로 다시 돌아간다.
			//exceptionNonThrows메서드의 try문 안에있는 exceptionRun()로 돌아가고 
			//catch문에 의해 예외 처리를 한다.
		}
		
}
