package exam06;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		/*
		 * StudentList 클래스를 여기에서 생성하고 실행한다.
		 */
		
		StudentList datas = new StudentList();
		
		datas.add("홍길동", 17, 1, 3);
		datas.add("박지수", 18, 2, 5);
		datas.add("김동현", 18, 2, 5);
		datas.add("최예원", 18, 2, 7);
		datas.add("서현우", 18, 2, 1);
		datas.add("이수연", 19, 3, 8);
		datas.add("윤서영", 19, 3, 4);
		
		int[] gg = datas.getGradeGroup("윤서영") ;
		System.out.println(Arrays.toString(gg));
		
		for(int i = 0; i < datas.length(); i++) {
			System.out.println(datas.getName(i) + " " + datas.getGrade(i) + "학년" + datas.getGroup(i) + "반");
		}
		
//		for(int i = 0; i < datas.length(); i++) {
//			System.out.println(datas.getName(i) + " " + datas.getAge(i) + "살");
//		}
		
//		System.out.println(Arrays.toString(datas.getTname(2)));
//		System.out.println(Arrays.toString(datas.getTname(2, 5)));
		
		datas.updateGrade("최예원", 3);
//		System.out.println(Arrays.toString(datas.getTname(3)));
//		System.out.println(Arrays.toString(datas.getTname(2)));
		
//		datas.nameRemove("박지수");
//		System.out.println(Arrays.toString(datas.getTname(2)));
//		datas.gradeRemove(2);
//		System.out.println(Arrays.toString(datas.getTname(2)));
	
		for(int i = 0; i < datas.length(); i++) {
			System.out.println(datas.getName(i) + " " + datas.getGrade(i) + "학년" + datas.getGroup(i) + "반");
		}
		
		datas.updateGroup("최예원", 13);
		int[] val = datas.getGradeGroup("최예원");
		System.out.println(Arrays.toString(val));
		
		datas.update("윤서영", 1, 1);
		for(int i = 0; i < datas.length(); i++) {
			System.out.println(datas.getName(i) + " " + datas.getGrade(i) + "학년" + datas.getGroup(i) + "반");
		}
	}

}
