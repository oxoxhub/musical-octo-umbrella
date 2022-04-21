package exam02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Sample02 {

	public static void main(String[] args) {
		/*
		 * Set을 이용해서 로또 번호 생성
		 * 		- 1 ~ 45 까지의 랜덤 번호를 생성하여 리스트에 담는다.
		 * 		- 중복된 값 없이 리스트에 담도록 한다.
		 * 		- 총 6개의 정수값을 리스트에 저장한다.
		 * 		- 마지막에 출력 할 때는 오름차순으로 정렬하여 출력되도록 한다.(Set을 List로 바꾸어서 출력)
		 */

		Random random = new Random();
		
		// Collection<Integer> lotto = new HashSet<Integer>(); 다형성 적용 가능
		Set<Integer> lotto = new HashSet<Integer>();
		
//		for(int i = 0; i < 6;) {
//			int r = random.nextInt(45) + 1;
//			//중복 값이 아니면 true 리턴되어서 값 저장
//			if(lotto.add(Integer.valueOf(r))) {
//				i++;
//			}
//		}
		
		for(int i = 0; lotto.size() < 6; i++) {
			int num = (int)(Math.random()*45) +1;
			lotto.add(Integer.valueOf(num));
//			lotto.add(num);
		}
		
		System.out.println(lotto);
		
		//List에 담아서 정렬해보기
		List<Integer> alist = new ArrayList<Integer>(lotto);
		Collections.sort(alist);
		System.out.println(alist);
		
		
	}

}
