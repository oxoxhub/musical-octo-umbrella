package exam02;

public class Sample09 {

	public static void main(String[] args) {
		/*
		 * 문자열에서 문자만 추출하는 방법
		 * 		문자열변수명.charAt(위치값)
		 */
		String s = "Hello Java Programming";
		char c = s.charAt(6);
		System.out.println(c);
		
		/*
		 * 문자열의 길이를 알아내는 방법 (문자열의 길이는 문자열의 문자 수를 의미)
		 * 		문자열변수명.length()
		 */
		
		s = "Hello Java Programming";
		int len = s.length();
		System.out.println("문자열의 문자수 : " + len);

	}

}
