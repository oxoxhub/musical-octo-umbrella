package exam01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class Sample02 {
	
	public static void main(String[] args) {
		/*
		 * 로또 번호 생성
		 * 		- 1 ~ 45 까지의 랜덤 번호를 생성하여 리스트에 담는다.
		 * 		- 중복된 값 없이 리스트에 담도록 한다.
		 * 		- 총 6개의 정수값을 리스트에 저장한다.
		 * 		- 마지막에 출력 할 때는 오름차순으로 정렬하여 출력되도록 한다.
		 */
		
		Random random = new Random();
		int rand = random.nextInt(45+1);

		
		List<Integer> lotto = new ArrayList<Integer>();
		
		
		for(int i = 0; i <random.nextInt(45+1); i++) {
			int r = random.nextInt(45) + 1;
			if(!lotto.contains(Integer.valueOf(r)));
			lotto.add(r);
			i++;
		}
		
		Collections.sort(lotto, new Comparator<Integer>() {

			@Override
			public int compare(Integer x, Integer y) {
				if(x > y) {
					return 1;
				} else if(x < y) {
					return -1;
				} else
				return 0;
			}
			
		});
		System.out.println(lotto);

	}

}
