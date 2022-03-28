package exam01;

public class Child extends Parent {
	
	/*
	 * 부모 클래스에 기본생성자 없이 매개변수가 있는 생성자만 있는 경우 
	 * 자식에서 부모를 생성할 때 사용할 기본 생성자가 없기 때문에 문제가 발생할 수 있다.
	 * 하지만 자식에서 super() 키워드로 매개변수가 있는 
	 * 부모 생성자를 명시하면 문제는 해결되며 또한 부모에 기본 생성자를 명시하면 해결됨.
	 */
	public Child(int number) {
		super(number); 		// 부모생성자 명시
	}
	
	//override 오버라이드 : 기존 부모 기능을 재정의
	//성립 조건 : 메서드 리턴 타입, 이름, 매개변수 모두 똑같이 적어야한다.
	//		- private 메소드 오버라이딩 불가, final 메소드 오버라이딩 불가
	//자식 메소드의 접근 범위가 부모 메소드의 접근 범위보다 넓거나 같아야 함. 
	//자식 객체를 통한 실행 시 후손 것이 우선권을 가짐
	
	@Override //Annotation
	//안해도 상관 없지만 오버라이딩이 가능한 메서드인지 확인하기 위한 용도로 쓰인다.
	//이름 다르거나하면 에러. The method getNumbers() of type Child must override or implement a supertype method.
	public int getNumber() {
		System.out.println("자식의 getNumber 메서드 시작");
		//참조변수 super. : 자식 클래스의 부모 객체를 가리키는 참조변수로 자식클래스 내에서 부모클래스 객체에 접근하여
		//필드나 메소드 호출시 사용.
		int num = super.getNumber();
		System.out.println("자식의 getNumber 메서드 끝");
		return num + 10;
	}

}
