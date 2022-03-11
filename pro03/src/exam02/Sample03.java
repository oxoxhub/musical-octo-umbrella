package exam02;

public class Sample03 {

	public static void main(String[] args) {
		// 값을 감소시키면서 반복
		for(int i  = 99; i > 0; i--) {
			System.out.println(i);
		}
		
		System.out.println("------------");
		
		for(char c = 'A'; c <= 'Z'; c++) {
			System.out.println(c);
		}
		
		System.out.println("------------");
		
		//아스키 코드 확인해보기
		for(char c = 'A'; c <= 'Z'; c++) {
			System.out.printf("%c <-> %d\n", c, (int)c);
		}
		
		System.out.println("------------");
		
		for(char c = 'a'; c <= 'z'; c++) {
			System.out.printf("%c <-> %d\n", c, (int)c);
		}
	}

}
