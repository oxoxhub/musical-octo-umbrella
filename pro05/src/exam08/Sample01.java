package exam08;

public class Sample01 {

	public static void main(String[] args) {
		MethodSample m1 = new MethodSample();
		m1.method01();
		m1.method02();
		
		//System.out.println(MethodSample.num1); 에러.
		System.out.println(m1.num1); //인스턴스 변수는 객체 생성 후에 사용 가능.
		System.out.println(MethodSample.num2);
		
		//MethodSample.method01(); -> 에러. non-static method
		MethodSample.method02(); //객체 생성 없이 호출 가능 왜냐하면 인스턴스 멤버와 관련없는 작업을 하는 메서드라서.
		
		int var1 = m1.method03();
		int[] var2 = m1.method04();
		String var3 = m1.method05();
		
		int[] var4 = new int[] {1,2,3};
		System.out.println("var4 : " + var4); //[I@762efe5d 참조값
		m1.method06(var4);
		int[] var5 = m1.method06(var4.clone()); //[I@5d22bbb7
		System.out.println("var4[0] : " + var4[0]); //얕은 복사
		System.out.println("var5[0] : " + var5[0]);
		
		//m1.method07(1,2,3,4); 
		//가변인자는 소괄호에 아무것도 쓰지 않는다.
		m1.method07(1,2,3,4,5); //[I@41a4555e 배열처럼 참조값이 나온다 그래서 for문으로 출력해주면 된다.
	}

}
