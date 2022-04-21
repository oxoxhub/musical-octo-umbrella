package exam02;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sample03 {

	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		Set<Integer> treeSet = new TreeSet<Integer>();
		
		hashSet.add(300); hashSet.add(900); hashSet.add(500);
		hashSet.add(400); hashSet.add(100); hashSet.add(700);
		hashSet.add(200); hashSet.add(600); hashSet.add(800);
		
		//LinkedHashSet : 입력한 순서대로 유지, 속도가 느려지는 단점
		linkedHashSet.add(300); linkedHashSet.add(900); linkedHashSet.add(500);
		linkedHashSet.add(400); linkedHashSet.add(100); linkedHashSet.add(700);
		linkedHashSet.add(200); linkedHashSet.add(600); linkedHashSet.add(800);
		
		//TreeSet : 정렬을 해준다, 속도가 느려지는 단점
		treeSet.add(300); treeSet.add(900); treeSet.add(500);
		treeSet.add(400); treeSet.add(100); treeSet.add(700);
		treeSet.add(200); treeSet.add(600); treeSet.add(800);
		
		System.out.println(hashSet);
		System.out.println(linkedHashSet);
		System.out.println(treeSet);
		
	}

}
