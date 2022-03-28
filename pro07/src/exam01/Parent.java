package exam01;

public class Parent {
	
	//상속은 가능하나 직접적으로 접근이 불가능하다
	//간접적으로 접근하는 방법은 getter/setter
	private int number = 10;
	
	//생성자는 상속되지 않는다.
	public Parent(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		System.out.println("부모의 getNumber 메서드 시작");
		System.out.println("부모의 getNumber 메서드 끝");
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

}
