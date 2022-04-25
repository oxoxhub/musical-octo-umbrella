package exam02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * Set 컬렉션
		 * 	- 무작위 순서, 중복 허용 안함
		 * 	- 자손은 Set, TreeSet(중복 X, 순서 정렬 O), LinkedHashSet(입력한 순서대로 유지)
		 */
		
		//다형성 적용으로 Collection사용 가능
		//Collection<Integer> a = new HashSet<Integer>();
		//Collection<Integer> a = new TreeSet<Integer>();
		
		Set<Integer> aSet = new HashSet<Integer>();
		aSet.add(100); aSet.add(200); aSet.add(300);
		aSet.add(400); aSet.add(500); aSet.add(600);
		System.out.println(aSet);
		
		//중복허용 안하므로 변화 없음
		aSet.add(100); aSet.add(200); aSet.add(300);
		System.out.println(aSet);
		
		//boolean add(E e) : 주어진 객체를 맨 끝에 추가
		//중복 값을 추가했으면 false, 중복 값이 아니면 true
		boolean res1;
		res1 = aSet.add(100);
		System.out.println(res1 + " " + aSet);
		
		res1 = aSet.add(700);
		System.out.println(res1 + " " + aSet);
		
		Set<Integer> bSet = new HashSet<Integer>();
		bSet.add(700); bSet.add(800); bSet.add(900);
		
		//추가가 됐으면 true 안됐으면 false(중복이라서)
		//여기선 true
		res1 = aSet.addAll(bSet);
		System.out.println(res1 + " " +aSet);
		
		//추가가 됐으면 true 안됐으면 false(중복이라서)
		//여기서는 중복이라 false
		res1 = aSet.addAll(bSet);
		System.out.println(res1 + " " +aSet);
		
		//boolean contains(Object o) : 주어진 객체가 저장되어 있는지 여부
		//중복이면 true
		res1 = aSet.contains(Integer.valueOf(100));
		System.out.println(res1);
		//중복 값이 아니라면 false
		res1 = aSet.contains(Integer.valueOf(150));
		System.out.println(res1);
		
		//boolean isEmpty() : 컬렉션이 비어 있는지 조사
		//컬렉션이 있으면 false
		res1 = bSet.isEmpty();
		System.out.println(res1);
		
		//비워져있으면 true
		//void clear() : 저장된 모든 객체를 삭제
		bSet.clear();
		res1 = bSet.isEmpty();
		System.out.println(res1);
		
		//boolean remove(Object o) : 주어진 객체를 삭제
		//삭제 성공 true
		res1 = aSet.remove(Integer.valueOf(100));
		System.out.println(res1 + " " + aSet);
		
		//삭제 실패 false (없는 객체라서)
		res1 = aSet.remove(Integer.valueOf(150));
		System.out.println(res1 + " " + aSet);
		
		//Iterator<E> iterator() : 저장된 객체를 한번씩 가져오는 반복자 리턴
		Iterator<Integer> iter = aSet.iterator();
		while(iter.hasNext()) {	// hasNext() : 읽어 올 요소가 남아있는지 확인한다. 있으면 true 없으면 false를 반환
			Integer i = iter.next();	// next() : 다음 요소를 읽어온다.
			System.out.print(i + "\t");
		}
		System.out.println();
		
		//for each 문 : 배열을 순환할 시, 반복문 보다 편리하게 순환할 수 있도록 새로운 문법을 제공
		for(Integer i: aSet) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		//순서가 없는 Set을 정렬하고싶으면 List에 담는 방법과 LinkedHashSet이 있다.
		// Set을 List로 변경
		List<Integer> aList = new ArrayList<Integer>(aSet);
		Collections.sort(aList);
		System.out.println(aList);

		ListIterator<Integer> iter1 = aList.listIterator(aList.size() - 1);
		while(iter1.hasPrevious()) {
			Integer data = iter1.previous();
			System.out.println("Previous : " + data);
		}
		
		// List를 Set으로 변경
		Set<Integer> cSet = new HashSet<Integer>(aList);
		System.out.println(cSet);
		
		// 배열로 변경
		Integer[] iArr = aList.toArray(new Integer[aList.size()]);
		System.out.println(Arrays.toString(iArr));
		iArr = cSet.toArray(new Integer[cSet.size()]);

	}

}
