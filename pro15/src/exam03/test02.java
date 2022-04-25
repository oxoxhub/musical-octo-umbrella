package exam03;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class test02 {

	public static void main(String[] args) {
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("김자바", 90);
		map.put("김자바", 100);
		map.put("이자바", 100);
		map.put("강자바", 80);
		map.put("안자바", 90);

		//키,값들 entry 저장
		Set<Entry<String, Integer>> entrys = map.entrySet();
		Iterator<Entry<String, Integer>> iter1 = entrys.iterator();
		while(iter1.hasNext()) {
			Map.Entry<String, Integer> entry = iter1.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
		   	System.out.println("[key]:" + key + ", [value]:" + value);
			//System.out.println("이름 : "+ e.getKey() + ", 점수 : " + e.getValue());
		}

		//Set<K> keySet() : 모든 키를 Set 객체에 담아서 리턴
		Set<String> keys = map.keySet();
		System.out.println("참가자 명단 : " + keys);

		//Collection<V> values() : 저장된 모든 값을 Collection에 담아서 리턴
		//map.values() : 반환값은 이 맵에 포함된 컬렉션의 값
		
		//Set<Integer> values1= new HashSet<Integer> (map.values());
		//Set으로 쓸경우 중복제거로인해 정확한 값 계산이 어려움
		Collection<Integer> values2 = map.values();
		Iterator<Integer> iter2 = values2.iterator();

		int total = 0;
		
		while(iter2.hasNext()) {
			int i = iter2.next();	//Integer i = iter2.next();
			int value = i;			//Integer value = i.intValue();
		   	System.out.println("[value]:" + value);
			total += i;
		}
		
//		System.out.println("for-each문 : ");
//		for(Integer i : map.values()) {
//			System.out.print(i + "\t");
//		}
		
		System.out.println();
		System.out.println("총점 : " + total);
		//System.out.println(entrys.size()); //4
		System.out.println("평균 : " + (float)total/entrys.size());
		System.out.println("최고점수 : " + Collections.max(values2));
		System.out.println("최저점수 : " + Collections.min(values2));
	}

}
