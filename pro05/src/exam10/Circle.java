package exam10;

public class Circle {
	
	private double PI = 3.14;
	private int radius = 1;
	private double area;
	private double size;
	
	public Circle() {
		//기본생성자
		getAreaOfCircle();
		getSizeOfCircle();
	}
	
	public void incrementRadius() {
		this.radius++;
		getAreaOfCircle();
		getSizeOfCircle();
	}
	
	public void getAreaOfCircle() {
		//원의 넓이를 구하는 메서드
		area = PI * radius * radius;
		System.out.println("원의 넓이 : " + area);
	}
	
	public void getSizeOfCircle() {
		//원의 둘레를 구하는 메서드
		size = 2 * PI * radius;
		System.out.println("원의 둘레 : " + size);
	}
	
	

}
