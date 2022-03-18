package exam07;

public class Sample03 {

	public static void main(String[] args) {
		Constructor01 c1 = new Constructor01(10);
		System.out.println(c1.num1);
		
		Constructor01 c2 = new Constructor01();
		System.out.println(c2.num1);
		
		Constructor01 c3 = new Constructor01(10);
		Constructor01 c4 = new Constructor01(10,20);
		Constructor01 c5 = new Constructor01(10,20,30);
		Constructor01 c6 = new Constructor01(10,20,30,40);

	}

}
