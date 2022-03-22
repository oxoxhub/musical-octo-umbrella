package exam07;

public class Constructor {
	public int num1;
	
	//매개변수가 없는 생성자
	//생성자가 없으면 자동으로 추가해주지만 다른 생성자가 하나라도 있으면 자동으로 추가되지 않는다.
	public Constructor() {}
	
	
	//매개변수가 있는 생성자
	public Constructor(int num1) {
		
		//this.은 자기자신을 의미. 매개변수와 구분하기 위해.
		this.num1 = num1;
		
	//메서드 이름은 하나밖에 못쓰지만 중복으로 사용하게 해주는게 메서드 오버로딩이다.
	//메서드 오버로딩 조건 : 매개변수 타입과 수가 달라야한다.
	}
	
	public Constructor(double num1) {
		this.num1 = (int)num1;
	}
	
	public Constructor(int num1, int num2) {
		this.num1 = num1;
	}
	
	public Constructor(int num1, double num2) {
		this.num1 = num1;
	}
}
