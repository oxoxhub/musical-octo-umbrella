package exam02;

import java.util.TreeSet;

public class test03 {

	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

		for(int i=0; i < score.length; i++)
			set.add(Integer.valueOf(score[i]));

		//headSet 주어진 값 포함하지 않고 작은 값들만
		System.out.println("50보다 작은 값 :" + set.headSet(Integer.valueOf(50)));
		//tailSet 주어진 값 포함하고 큰 값들만
		System.out.println("50보다 큰 값:"  + set.tailSet(Integer.valueOf(50)));
		//80은 포함하지 않는다.
		System.out.println("40과 80사이에 있는 값: " + set.subSet(40, 80));	//[45, 50, 65]
	}

}
