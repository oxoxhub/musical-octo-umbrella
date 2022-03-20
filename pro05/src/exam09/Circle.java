package exam09;

public class Circle {

	private final static double _PI = 3.14;
	private double radius;
	private double round;
	private double area;
	
	public Circle() {}
	
	public Circle(double radius) {
		setRadius(radius);
	}
	
	// setter : 매개값을 검증해서 유요한 값만 객체의 필드로 저장할 수 있게 함.
	public void setRadius(double radius) {
		this.radius = radius;
		_area();	_round();
	}
	
	// getter : 메소드로 필드값을 가공한 후 외부로 전달
	public double getRadius() {
		return radius;
	}
	
	// getter
	public double getDiamiter() {
		return radius * 2;
	}
	
	// getter
	public double getArea() {
		return area;
	}
	
	// getter
	public double getRound() {
		return round;
	}
	
	//_언더바를 붙인 이유는 구분하기 위해서이고 필수는 아니다.
	private void _area() {
		area = _PI * radius * radius;
	}
	
	private void _round() {
		round = 2 * _PI * radius;
	}
}
