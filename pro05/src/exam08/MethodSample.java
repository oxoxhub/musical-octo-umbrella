package exam08;

public class MethodSample {
	
	public int num1;		//인스턴스 변수 = 멤버 변수(필드)
	public static int num2;	//클래스 변수 = 정적 변수 = 정적 멤버 변수(필드)
	
	//일반메서드
	public void method01() {
		System.out.println("일반(인스턴스) 메서드 실행됨.");
	}
	
	//static 메서드
	public static void method02() {
		System.out.println("static(정적/클래스) 메서드 실행됨.");
	}
	
	public int method03() {
		return 0;
	}
	
	public int[] method04() {
		int[] result = new int[3];
		return result;
		//return new int[3]; 위와 같은 코드를 간단히
	}
	
	public String method05() {
		String result = new String();
		return result;
		//return null; -> String 타입은 null로도 리턴 할수있다.
		//return new String();
	}
	
	public int[] method06(int[] arr) {
		//return new int[] {1,2,3};
		System.out.println(arr); //[I@762efe5d 참조값
		arr[0] = 10;
		return arr;
	}
	
	//가변인자
	//public void method07 (int n1, int n2, int n3, int n4) 이렇게 하면 너무 많아져서 가변인자를 사용한다.
	//가변인자 사용시 뒤에 다른 인자가 들어가면 안된다. 넣고싶다면 (String s1, int ... nums)처럼 앞에 적어준다. 가변인자는 항상 마지막에 적어야한다.
	public void method07 (int ...nums) { // 0 ~ n개 입력 가능
		System.out.println(nums); // [I@41a4555e 배열처럼 참조값이 나온다
		for(int i = 0; i<nums.length; i++) {
			System.out.println(nums[i]);
		}
	}

}
