package exam01;

import java.util.Arrays;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * String 생성자
		 */
		String s1 = new String();
		String s2 = new String("생성자");
		
		char[] cArr = new char[] {'A', 'B', 'C', 'D'};
		String s3 = new String(cArr);
		
		byte[] bArr = new byte[] {65, 66, 67, 68};
		String s4 = new String(bArr);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		/*
		 * String 관련 메서드
		 */
		String s5, s6;
		
		s5 = new String("동일문자열비교");
		s6 = new String("동일문자열비교");
		
		boolean isEqual = s5.equals(s6);
		System.out.println("s5.equals(s6) -> " + isEqual);
		
		int len = s5.length();
		System.out.println("s5.length() -> " + len);
		
		for(int i = 0; i < s5.length(); i++) {
			char c1 = s5.charAt(i);
			System.out.printf("s5.charAt(%d) -> %c\n", i, c1);
		}
		
		boolean isContains;
		s5 = "Java Programming Language";
		isContains = s5.contains("Program");
		System.out.println("s5.contains(\"Program\") -> " + isContains);
		
		isContains = s5.contains("program");
		System.out.println("s5.contains(\"program\") -> " + isContains);
		
		//인덱스를 찾아주는 메서드
		int location;
		location = s5.indexOf("Program");
		System.out.println("s5.indexOf(\"Program\") -> " + location);
		
		location = s5.indexOf("program");
		System.out.println("s5.indexOf(\"program\") -> " + location);
		
		//특정 문자열을 다시 입력하는 메서드
		s5 = s5.replace("Program", "프로그램");
		System.out.println("s5.replace(\"Program\", \"프로그램\") -> " + s5);
		
		//대소문자 구분한다.
		s5 = s5.replace("java", "자바");
		System.out.println("s5.replace(\"java\", \"자바\") -> " + s5);
		
		//입력한 기준으로 문자열을 나눠준다.
		String[] sArr;
		sArr = s5.split(" ");
		System.out.println("s5.split(\" \") -> " + Arrays.toString(sArr));
		System.out.println(sArr[0]);
		System.out.println(sArr[1]);
		System.out.println(sArr[2]);
		
		//나눠져있는 문자열을 합쳐준다.
		s5 = String.join("_", sArr);
		System.out.println("String.join(\"_\", sArr) -> " + s5);
		
		s5 = "     앞/뒤로 공백이 존재하는 문자열     ";
		System.out.println(s5);
		
		//공백을 제거해주는 메서드
		s5 = s5.trim();
		System.out.println("s5.trim() -> " + s5);
		
		//모든 문자열을 대문자 toUpperCase 
		//소문자 toLowerCase 로 바꿔주는 메서드
		s5 = "String Methods";
		System.out.println("s5.toUpperCase() -> " + s5.toUpperCase());
		System.out.println("s5.toLowerCase() -> " + s5.toLowerCase());
		
		// substring : 입력한 특정 인덱스부터 문자열을 찾아주는 기능
		System.out.println("s5.substring(3, 6) -> " + s5.substring(3, 6));
		System.out.println("s5.substring(7, 11) -> " + s5.substring(7, 11));
		System.out.println("s5.substring(7, 11) -> " + s5.substring(s5.indexOf("Meth"), s5.indexOf("Meth") + 4));
		
		s6 = "Meth";
		System.out.println("s5.substring(7, 11) -> " + s5.substring(s5.indexOf(s6), s5.indexOf(s6) + s6.length()));
		
		// System.out.printf("포멧형식이 있는 문자열", 포멧형식에사용할값....)
		s6 = String.format("%d / %s / %.1f", 10, "포멧문자열", 10.123);
		System.out.println(s6);
		
		s6 = "02-ertf-5678";
		boolean isMatch = s6.matches("\\d{3}-\\d{4}-\\d{4}"); // ("정규표현식")
		System.out.println("전화번호 형식과 일치합니까? -> " + isMatch);
	}

}
