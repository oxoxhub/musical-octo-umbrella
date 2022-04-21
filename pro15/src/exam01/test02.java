package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class test02 {
	public static void main (String[] args) throws java.lang.Exception {
		
		/*
		 * Comparator 사용하기
		 */
		
		List<Student1> list1 = new ArrayList<Student1>();
		
		list1.add(new Student1("a", 5));
		list1.add(new Student1("b", 10));
		list1.add(new Student1("c", 1));
		list1.add(new Student1("d", 52));
		list1.add(new Student1("e", 23));
		
		Collections.sort(list1, new Comparator<Student1>() {
			@Override
			public int compare(Student1 s1, Student1 s2) {
				if (s1.getScore() < s2.getScore()) {
					return -1;
				} else if (s1.getScore() > s2.getScore()) {
					return 1;
				}
				return 0;
			}
		});
		
		/*
		 * 결과
		 * 1
		 * 5
		 * 10
		 * 23
		 * 52
		 */
		 
		for (Student1 s : list1) {
			System.out.println(s.getScore());
		}
	}
}

	 
	class Student1 {
	    String name;
	    int score;
	    
	    public Student1(String name, int score) {
	        this.name = name;
	        this.score = score;
	    }
	    
	    public String getName() {
	        return this.name;
	    }
	    
	    public int getScore() {
	        return this.score;
	    }

}
