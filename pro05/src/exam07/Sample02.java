package exam07;

public class Sample02 {

	public static void main(String[] args) {
		//매개변수가 있는 생성자 호출
		Constructor c1 = new Constructor(10);
		System.out.println(c1.num1);
		
		//매개변수가 없는 기본 생성자 호출
		//매개변수가 없는 기본 생성자라서 jvm 기본값이 출력된다.
		Constructor c2 = new Constructor();
		System.out.println(c2.num1);
		
		Constructor c3 = new Constructor(12.4);
		System.out.println(c3.num1);
		
	}

}
