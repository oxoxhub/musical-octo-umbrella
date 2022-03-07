package exam01;

public class Sample01 {

	public static void main(String[] args) {
		int i1 = 500;
		byte b1;
		
		b1 = (byte)i1; //강제형변환 = 값 손실 감수
		//b1 = i1; 에러. 왜냐? 강제 형변환을 하지 않아서
		//Type mismatch: cannot convert from int to byte

		System.out.println(i1);
		System.out.println(b1);
		
		byte b2 = 100;
		int i2;
		
		i2 = b2; //자동형변환
		
		double d1 = 10.4;
		int i3 = 5;
		int i4;
		
		//i4 = i3 + d1; 에러.
		i4 = (int)(i3 + d1);  //자동 형변환(i3을 double로), 강제 형변환(int로)
		System.out.println(i4);
		
		double d2 = 10.6;
		double d3 = 10.7;
		int i5, i6;
		
		i5 = (int)(d2 + d3);
		i6 = (int)d2 + (int)d3;
		
		System.out.println(i5);
		System.out.println(i6);
		
		int i7 = 0;
		//boolean b3 = (boolean)i7;
		//boolean형의 캐스팅은 안됨.
		//Cannot cast from int to boolean
		
		String s2 = "100";
		//i7 = (int)s2;
		//문자열도 기본 자료형으로 캐스팅 불가.
		//Cannot cast from String to int
		
		s2 = i7 + " "; //캐스팅은 아니지만 기본 타입을 문자열로 변환할 수 있다.
		
		
	}

}
