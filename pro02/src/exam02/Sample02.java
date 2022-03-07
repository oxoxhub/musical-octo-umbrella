package exam02;

public class Sample02 {

	public static void main(String[] args) {
		// printf 활용하여 표형식으로 출력(정렬)
		//		가급적 영문자로만 작성하세요.
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8s|\n", "name", "age");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Hong", 34);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Kim", 28);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Park", 19);
		System.out.print("+--------+--------+\n");
		
		System.out.println(); //위 출력과 구분하기 위한 개행.
		
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8s|\n", "name", "age");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8d|\n", "Hong", 34);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8d|\n", "Kim", 28);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8d|\n", "Park", 19);
		System.out.print("+--------+--------+\n");
		
		System.out.println(); //위 출력과 구분하기 위한 개행.
		
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8s|\n", "name", "age");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "Hong", 34.0);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "Kim", 28.0);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "Park", 19.0);
		System.out.print("+--------+--------+\n");
		
		//8자리 중 5자리는 정수 2자리는 소수점 1자리는 . 소수점
		//소수점을 크게하면 8자리 공간에서 벗어날 수 밖에 없다. 오류는 안남.
		
		System.out.println();
		
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8s|\n", "이름", "나이");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "홍길동", 34);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "김스티븐", 28);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "박마리아나", 19);
		System.out.print("+--------+--------+\n");
		
		/* 터미널 (콘솔)
		 * 영문자 ->1자
		 * 한글 ->2자
		 */
		
	}

}
