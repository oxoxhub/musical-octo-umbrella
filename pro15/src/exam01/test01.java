package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class test01 {
	
	public static void main (String[] args) throws java.lang.Exception {
        
		/*
		 * compareTo 사용하기
		 */
		
		List<Student> list = new ArrayList<Student>();
        
        list.add(new Student("a", 5));
        list.add(new Student("b", 10));
        list.add(new Student("c", 1));
        list.add(new Student("d", 52));
        list.add(new Student("e", 23));
        
        Collections.sort(list);
        
        for (Student s : list) {
            System.out.println(s.getScore());
        }
        /*
         * 결과
         * 1
         * 5
         * 10
         * 23
         * 52
         */
    }
}
 
	class Student implements Comparable<Student> {
	    String name;
	    int score;
	    
	    public Student(String name, int score) {
	        this.name = name;
	        this.score = score;
	    }
	    
	    public String getName() {
	        return this.name;
	    }
	    
	    public int getScore() {
	        return this.score;
	    }

	    //comparteTo(T o) : 이 개체를 지정된 개체와 비교하여 순서를 지정합니다. 
	    //이 개체가 지정된 개체보다 작거나 같거나 크면 음의 정수, 0 또는 양의 정수를 반환합니다
	    @Override
	    public int compareTo(Student s) {
	        if (this.score < s.getScore()) {
	            return -1;
	        } else if (this.score > s.getScore()) {
	            return 1;
	        }
	        return 0;
	    }


}
