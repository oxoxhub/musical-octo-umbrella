package exam02.pack2;

//import exam.02.pack1.*; 는 pack1의 모든 클래스를 import한다.
import exam02.pack1.PublicAccessTest; //import문이 없다면 아래처럼 패키지명 생략을 못하고 적어줘야한다.
import exam02.pack1.DefaultAccessTest;
//The type exam02.pack1.DefaultAccessTest is not visible

public class Sample02 {

	public static void main(String[] args) {
		exam02.pack1.PublicAccessTest p = new exam02.pack1.PublicAccessTest();
		DefaultAccessTest d = new DefaultAccessTest();
	}

}
