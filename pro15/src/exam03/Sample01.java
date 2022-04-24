package exam03;

import java.util.ArrayList;
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
		 *	  구현 클래스로 HashMap, Hashtable, LinkedHashMap, Properties, TreeMap이 있음
		 */
		
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		
		//순서가 없다
		aMap.put("가", 100); aMap.put("나", 200); aMap.put("다", 300);
		System.out.println(aMap);

		//키는 있으니 값은 400으로 덮어쓰고 리턴은 기존 값이 리턴된다
		Integer res1;
		res1 = aMap.put("가", 400);
		System.out.println(res1 + " " + aMap);
		
		//키가 없다면 null로 리턴된다. (중복됐는지 확인가능하다)
		res1 = aMap.put("라", 500);
		System.out.println(res1 + " " + aMap);
		
		//containsKey : 키 중복 확인하는 메서드
		boolean res2;
		res2 = aMap.containsKey("가");
		System.out.println(res2);
		
		res2 = aMap.containsKey("마");
		System.out.println(res2);
		
		//containsValue : 값 중복 확인하는 메서드
		res2 = aMap.containsValue(Integer.valueOf(200));
		System.out.println(res2);
		
		res2 = aMap.containsValue(Integer.valueOf(100));
		System.out.println(res2);

		//"가"라고 하는 키를 가지고있는 값을 가져와라
		//키가 없으면 null로 나온다.
		res1 = aMap.get("가");
		System.out.println(res1);
		
		//키가 가지고 있는 값을 반환하되 없으면 Default로 설정한 값을 반환
		res1 = aMap.getOrDefault("바", Integer.valueOf(0));
		System.out.println(res1);
		
		//키만 출력
		Set<String> keys = aMap.keySet();
		System.out.println(keys);
		
		for(String k: aMap.keySet()) {
			System.out.print(k + "\t");
		}
		System.out.println();
		
		//값만 출력
		Set<Integer> values= new HashSet<Integer> (aMap.values());
		System.out.println(values);
		
		List<Integer> values2 = new ArrayList<Integer>(aMap.values());
		System.out.println(values2);
		
		for(Integer i : aMap.values()) {
			System.out.print(i + "\t");
		}
		System.out.println();
		
		Set<Entry<String, Integer>> entrys = aMap.entrySet();
		System.out.println(entrys);
		for(Entry<String, Integer> entry : entrys) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
		}
		System.out.println();
		
		for(Entry<String, Integer> entry : aMap.entrySet()) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
		}
		System.out.println();
		
		Set<Entry<String, Integer>> entrys2 = aMap.entrySet();
		Iterator<Entry<String, Integer>> iter = entrys2.iterator();
		while(iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		
		res1 = aMap.remove("가");
		System.out.println(res1 + " " + aMap);
		
		aMap.remove("나", Integer.valueOf(300));
		System.out.println(aMap);
		aMap.remove("나", Integer.valueOf(200));
		System.out.println(aMap);
		
		
	}

}
