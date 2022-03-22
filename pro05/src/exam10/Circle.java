package exam10;

public class Circle {
	
	private final double PI = 3.14;
	private int radius = 1;
//	private double area;
//	private double size;
	
	public Circle() {
		//기본생성자
	}
	
	public void incrementRadius() {
		//반지름의 크기를 1 증가시키는 메서드
		radius++;
	}
	
	public void getAreaOfCircle() {
		//원의 넓이를 구하는 메서드
		double area = PI * radius * radius;
		System.out.println("원의 넓이 : " + area);
	}
	
	public void getSizeOfCircle() {
		//원의 둘레를 구하는 메서드
		double size = 2 * PI * radius;
		System.out.println("원의 둘레 : " + size);
	}
	
	

}
