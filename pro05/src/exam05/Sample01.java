package exam05;

import java.util.Random;

public class Sample01 {

	public static void main(String[] args) {
		
		Circle cir1 = new Circle();
		Circle cir2 = new Circle();
		
		cir1.radius = 1.5;
		cir1.diamiter = cir1.radius * 2;
		cir1.area = cir1.radius * cir1.radius * Circle.PI; //cir1.PI 보다는 클래스명 적기
		
		cir2.radius = 3.5;
		cir2.diamiter = cir2.radius * 2;
		cir1.area = cir2.radius * cir2.radius * Circle.PI;
		
		Rectangle r1 = new Rectangle();
		Rectangle r2 = new Rectangle();
		
		r1.width = cir1.diamiter;
		r2.width = cir2.diamiter;
		System.out.println(r1.width + "|" + r2.width);
		
		Random rand = new Random();
		
		r1.height = rand.nextInt(7) + 3;
		r2.height = rand.nextInt(7) + 3;
		System.out.println(r1.height +"|" + r2.height);
		
		r1.area = r1.width * r1.height;
		r2.area = r2.width * r2.height;
		System.out.println(r1.area + "|" + r2.area);
		

	}

}
