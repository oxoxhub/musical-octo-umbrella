package exam03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Sample01 {

	public static void main(String[] args) {
		/*
		 * Map 컬렉션 :
		 *	  키(key)와 값(value)으로 구성되어 있으며, 키와 값은 모두 객체
		 *	  키는 중복 저장을 허용하지 않고(Set방식), 값은 중복 저장 가능(List방식)
		 *	  키가 중복되는 경우, 기존에 있는 키에 해당하는 값을 덮어 씌움
		 *	  구현 클래스로 HashMap, HashTable, LinkedHashMap, Properties, TreeMap이 있음
		 *
		 *	-HashMap과 HashTable은 거의 유사하다. HashMap이 최신버전이며 동기화 불가능, HashTable은 old버전이며 동기화 가능.
		 *	-TreeMap과 TreeSet은 거의 유사하다.
		 */
		
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		
		// 순서가 없다.
		aMap.put("가", 100); aMap.put("나", 200); aMap.put("다", 300);
		System.out.println("1. " + aMap);

		// V put(K key, V value) : key가 중복이라면 value만 덮어쓰고 리턴은 기존 저장된 value가 리턴된다
		Integer res1;
		res1 = aMap.put("가", 400);
		System.out.println("2. 기존 저장된 value 리턴값 : " + res1 + " " + aMap);
		
		// 키가 없다면 null로 리턴되고 추가 가능. (중복 확인 기능)
		res1 = aMap.put("라", 500);
		System.out.println("3. 기존 저장된 value 리턴값 : " + res1 + " " + aMap);
		
		// boolean containsKey(Object key) : 주어진 키가 있는지 확인하여 결과 리턴
		// 중복 key라면 true 아니라면 false
		boolean res2;
		res2 = aMap.containsKey("가");
		System.out.println("4. containsKey(\"가\") 리턴값 : " +res2);
		
		res2 = aMap.containsKey("마");
		System.out.println("5. containsKey(\"마\") 리턴값 : " +res2);
		
		// boolean containsValue(Object value) : 주어진 값이 있는지 확인하여 결과 리턴
		// 중복 value라면 true 아니라면 false
		res2 = aMap.containsValue(Integer.valueOf(200));
		System.out.println("6. containsValue(200) 리턴값 : " +res2);
		
		res2 = aMap.containsValue(Integer.valueOf(100));
		System.out.println("7. containsValue(100) 리턴값 : " +res2);

		//V get(Object key) : 주어진 키의 값을 리턴
		//키가 없으면 null로 나온다.
		res1 = aMap.get("가");
		System.out.println("8. get(\"가\")의 value 리턴값 : " + res1);
		
		//키가 가지고 있는 값을 반환하되 없으면 Default로 설정한 값을 반환
		res1 = aMap.getOrDefault("바", Integer.valueOf(0));
		System.out.println("9. getOrDefault(\"바\") 리턴값 : " + res1);
		System.out.println();
		
		//Set<K> keySet() : 모든 키를 Set 객체에 담아서 리턴
		Set<String> keys = aMap.keySet();
		System.out.println("10. keySet() 키만 출력 : " + keys);
		
		System.out.println("11. (for-each문) 키만 출력 : ");
		for(String k: aMap.keySet()) {
			System.out.print(k + "\t");
		}
		System.out.println();
		System.out.println();
		
		
		//Collection<V> values() : 저장된 모든 값을 Collection에 담아서 리턴
		Set<Integer> values= new HashSet<Integer> (aMap.values()); //HashSet은 순서x, 중복x
		System.out.println("12. HashSet values() 값만 출력 : " + values);
		
		List<Integer> values2 = new ArrayList<Integer>(aMap.values()); //ArrayList는 순서o, 중복o
		System.out.println("13. ArrayList values() 값만 출력 : " + values2);
		Collections.sort(values2);
		System.out.println("13-1. ArrayList에 담아서 정렬 : " + values2);
		
		System.out.println("14. (for-each문) 값만 출력 : ");
		for(Integer i : aMap.values()) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println();
		
		
		//Set<Map.Entry<K,V>> entrySet() : 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 set에 담아서 리턴
		Set<Entry<String, Integer>> entrys = aMap.entrySet();
		System.out.println("15. entrySet() 키&값 출력 : " + entrys);
		
		System.out.println("15-1. (for-each문 + 변수명) 키&값 출력 : ");
		for(Entry<String, Integer> entry : entrys) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
		}
		System.out.println();
		
		System.out.println("16. (for-each문 + entrySet()) 키&값 출력 : ");
		for(Entry<String, Integer> entry : aMap.entrySet()) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
		}
		System.out.println();
		System.out.println();
		
		//iterator 앞->뒤로 검색
		Set<Entry<String, Integer>> entrys2 = aMap.entrySet();
		Iterator<Entry<String, Integer>> iter = entrys2.iterator();
		System.out.println("17. iterator 키&값 출력 : ");
		while(iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		System.out.println();
		
		
		//V remove(Object key) : 주어진 키와 일치하는 Map.Entry 삭제, 삭제가 되면 값을 리턴한다.
		res1 = aMap.remove("가");
		System.out.println("18.remove(\"가\")의 value 리턴값 : " + res1 + " " + aMap);
		
		res2 = aMap.remove("나", Integer.valueOf(300));
		System.out.println("19.remove(\"나\")의 (300) value 리턴값 : " + res2 + " "  + aMap);
		res2 = aMap.remove("나", Integer.valueOf(200));
		System.out.println("20.remove(\"나\")의 (200) value 리턴값 : " + res2 + " "  + aMap);
		
		//void clear() : 모든 Map.Entry를 삭제함
		aMap.clear();
		System.out.println("21.aMap.clear() 출력 : " + aMap);
		
		
	}

}
