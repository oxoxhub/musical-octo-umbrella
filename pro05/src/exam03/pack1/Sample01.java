package exam03.pack1;

public class Sample01 {

	public static void main(String[] args) {
		AccessMain a = new AccessMain();
		System.out.println(a.v1);
		System.out.println(a.v2);
		System.out.println(a.v3);
		System.out.println(a.v4); //같은 패키지 내에서만 가능하기때문에.
	}

}
