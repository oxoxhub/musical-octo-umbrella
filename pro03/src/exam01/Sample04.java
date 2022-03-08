package exam01;

import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 * Scanner를 사용하여 사용자 입력을 받고 다음의 출력 결과가 나오도록 하시오.
		 * 		1. 사용자 입력을 통해 국어 , 영어, 수학 점수를 입력 받는다. (정수 데이터를 입력 받는다.)
		 * 		2. 입력 받은 정수 데이터의 값에 대해 총점과 평균을 구한다.
		 * 		3. 평균 점수가 60점 이상인 경우에만 다음의 메시지를 출력한다.
		 * 			축하 합니다. 합격입니다.
		 * 				총점 : 213 점
		 * 				국어 : 75 점
		 * 				영어 : 70 점
		 * 				수학 : 68 점
		 * 				평균 : 71.0 점
		 * 		4. 평균 점수가 60 점 미만인 경우에는 다음의 메시지를 출력한다.
		 * 			평균 점수가 미달하였습니다.
		 * 		5. 국어, 영어, 수학 과목중 40점 미만의 과목이 있는 경우 다음의 메시지를 출력한다.
		 * 			과락된 과목이 있어 불합격 되었습니다.
		 */
		
		int kor, eng, mth, tot;
		double avg;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수를 입력하세요(0~100) : ");
		kor =sc.nextInt();
		
		System.out.print("영어 점수를 입력하세요(0~100) : ");
		eng =sc.nextInt();
		
		System.out.print("수학 점수를 입력하세요(0~100) : ");
		mth =sc.nextInt();
		
		tot = kor + eng + mth;
		avg = tot / 3.0 ;
		
//		System.out.println("총점 : " + result1 + " 평균 : " + (double)result2);
		
		if(kor < 40 || eng < 40 || mth < 40) {
			System.out.println("과락된 과목이 있어 불합격 되었습니다.");
		} else {
			if(avg >= 60) {
				System.out.println("축하 합니다. 합격입니다.");
				System.out.printf(" 총점 : %d%s\n", tot, "점");
				System.out.printf(" 국어 : %d%s\n", "국어", kor, "점");
				System.out.printf(" 영어 : %d%s\n", "영어", eng, "점");
				System.out.printf(" 수학 : %d%s\n", "수학", mth, "점");
				System.out.printf(" 평균 : %d%s\n", "평균", avg, "점");
			} else {
				System.out.println("평균 점수가 미달하였습니다.");
			} 
		
		}
	}
	
}
