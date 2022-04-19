package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * List 컬렉션 - ArrayList
		 * 	:순서를 유지하고 저장, 중복 저장 가능
		 */
		List<Integer> aList = new ArrayList<Integer>();
		
		//add : 주어진 객체를 맨 끝에 추가
		aList.add(100);
		System.out.println(aList);
		aList.add(200);
		System.out.println(aList);
		aList.add(300);
		System.out.println(aList);
		
		//add(인덱스, 값) :원하는 인덱스에 객체를 저장
		aList.add(2, 400);
		System.out.println(aList);
		
		List<Integer> bList = new ArrayList<Integer>();
		bList.add(500); bList.add(600); bList.add(700);
		System.out.println(bList);
		
		//addAll : 주어진 Collection타입 객체를 리스트에 추가
		aList.addAll(bList);
		System.out.println(aList);
		
		//set : 주어진 인덱스에 저장된 객체를 주어진 객체로 바꿈
		//원래 저장된 객체를 리턴가능
		Integer result1 = aList.set(2, 350);
		System.out.println(result1 + " | " + aList);
		result1 = aList.set(3, 450);
		System.out.println(result1 + " | " + aList);
		
		//contains : aList 객체에 중복이 있나 없나, 주어진 객체가 저장되어 있는지 여부
		//Integer객체 100이라고하는 값이 aList에 포함되어있냐 없냐
		boolean result2 = aList.contains(Integer.valueOf(300));
		System.out.println(result2);
		
		//indexOf: 주어진 값이 aList의 몇번 인덱스에 있는지 알아보는 메서드
		//없으면 -1
		int result3 = aList.indexOf(Integer.valueOf(500));
		System.out.println(result3);
		
		//isEmpty: bList 컬렉션이 비어 있는지 조사. boolean리턴
		result2 = bList.isEmpty();
		System.out.println(result2);
		
		//isEmpty : 저장된 모든 객체를 삭제
		bList.clear();
		result2 = bList.isEmpty();
		System.out.println(result2);
		
		//aList 객체에 Integer 객체가 몇개 저장되어있냐
		//저장되어 있는 전체 객체 수 리턴
		result3 = aList.size();
		System.out.println(result3);
		
		//remove : 주어진 인덱스에 저장된 객체 삭제
		//삭제된 객체 리턴 가능
		System.out.println(aList);
		result1 = aList.remove(0);
		System.out.println(result1 + " " + aList);
		
		//저장된 값으로도 객체 삭제가능
		aList.remove(Integer.valueOf(600));
		System.out.println(aList);
		
		//주어진 인덱스에 저장된 객체를 리턴
		for(int i = 0; i < aList.size(); i++) {
			System.out.println("aList [" + i + "] => " + aList.get(i));
		}
		
		System.out.println("<<<<< Iterator 사용 >>>>>");
		//Iterator : 저장된 객체를 한번씩 가져오는 반복자 리턴
		//length길이를 몰라도 반복을 시킬수있다.
		Iterator<Integer> iter = aList.iterator();
		while(iter.hasNext()) {	// hasNext() : 다음 값이 있나없나
			Integer i1 = iter.next();	// next() : 있으면 가져온다
			System.out.println(i1);
		}
		
		//배열을 순환할 시, 반복문 보다 편리하게 순환할 수 있도록 새로운 문법을 제공
		System.out.println("<<<<< for each 문 >>>>>");
		for(Integer i2: aList) {
			System.out.println(i2);
		}
		
		System.out.println(aList); // [200, 350, 450, 500, 700]
		
		//Collections.reverse : list의 요소의 순서를 반전시킨다
		Collections.reverse(aList);
		System.out.println(aList);	// [700, 500, 450, 350, 200]
		System.out.println(aList.get(1));	// [500] reverse해서 인덱스 1번의 값이 350이 아닌 500으로 변경되었다.
		
		//Collections.sort : 오름차순
		Collections.sort(aList);
		System.out.println(aList); // [200, 350, 450, 500, 700]
		
		// 내림차순은 sort 후 reverse 를 한다.
		Collections.sort(aList); // [200, 350, 450, 500, 700]
		Collections.reverse(aList);	// [700, 500, 450, 350, 200]
		System.out.println(aList);
		
		//원하는 인덱스에 객체 추가. 원래 객체는 뒤로 밀린다.
		aList.add(3, 150);
		aList.add(1, 250);
		aList.add(4, 550);
		
		System.out.println(aList);	//[700, 250, 500, 450, 550, 150, 350, 200]
		
		//Comparator : 객체 x,y를 비교하여 음수,0,양수로 나타내어 sort 오름차순 혹은 내림차순을 해주는 메서드
		Collections.sort(aList, new Comparator<Integer>() {
			@Override
			public int compare(Integer x, Integer y) {
				if(x > y) {		//x < y 이면 내림차순이 된다.
					return 1;
				} else if(x < y) {	//x > y
					return -1;
				} else {
					return 0;
				}
			}
		});
		
		System.out.println(aList);
		
		List<Person> pList = new ArrayList<Person>();
		
		pList.add(new Person("홍길동", 23));
		pList.add(new Person("김철수", 23));
		pList.add(new Person("김철수", 21));
		pList.add(new Person("김철수", 25));
		
		System.out.println(pList); //클래스내에 toString() 메서드가 꼭 필요하다.
		
		Collections.sort(pList, new Comparator<Person>() {
			@Override
			public int compare(Person x, Person y) {
				//compareTo() : 두 문자열을 사전순으로 비교합니다. 비교는 문자열에 있는 각 문자의 유니코드 값을 기반으로 합니다. 
				if(x.getName().compareTo(y.getName()) > 0) {		// >,< 반대로할시 내림차순
					//이 String 객체가 사전식으로 인수 문자열을 따르는 경우 결과는 양의 정수입니다. 
					return 1;
				} else if(x.getName().compareTo(y.getName()) < 0) {		// >,< 반대로할시 내림차순
					//이 String이 객체 사전순으로 인수 문자열보다 선행하는 경우 결과는 음의 정수입니다. 
					return -1;
				} else {
					if(x.getAge() < y.getAge()) {	// >,< 반대로할시 내림차순
						return -1;
					} else if(x.getAge() > y.getAge()) {	// >,< 반대로할시 내림차순
						return 1;
					}
				}
				return 0;
			}
			
		});
		System.out.println(pList);
	}

}
