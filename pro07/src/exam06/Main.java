package exam06;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		/*
		 *  - 일반 고객 5명을 생성한다.
		 *  - 일반 고객 5명을 랜덤으로 선택하여 랜덤한 가격으로 물품 구입하게 한다.
		 *  - 물품 누적 구입액이 1,000,000 원을 초과하면 프리미엄 고객으로 전환을 시켜서 다음 번
		 *  	물품 구입에 할인율이 적용될 수 있게 만든다.
		 *  - 고객이 물품을 구입하는 작업을 반복문을 이용하여 작업한다. (반복횟수는 100번)
		 *  
		 *  일반고객 -> 프리미엄 고객 전환
		 *  		General n1 = new General("홍길동", 35, 'M');
		 *  		Premium p1 = new Premium(n1.getName(), n1.getAge(), n1.getGender());
		 */
		
		Random rand = new Random();
		Customer[] cArr = new Customer[5];
		
		cArr[0] = new General("홍길동", 35, 'M');
		cArr[1] = new General("고길동", 45, 'M');
		cArr[2] = new General("강조석", 25, 'M');
		cArr[3] = new General("최조한", 38, 'M');
		cArr[4] = new General("라주성", 29, 'M');
		
		
		for(int i = 0; i < 100; i++) {
			int idx = rand.nextInt(cArr.length);
			cArr[idx].buy("xxxxxx", (int)(rand.nextInt(500000)+10000) / 10000 * 10000);
			
			if(cArr[idx] instanceof General) {
				if(cArr[idx].getPriceTotal() > 1000000) {
					Premium p = new Premium(cArr[idx].getName(), cArr[idx].getAge(), cArr[idx].getGender());
					p.setPriceTotal(cArr[idx].getPriceTotal());
					cArr[idx] = p;
					System.out.printf("%s님의 등급이 프리미엄으로 상향되었습니다.\n", cArr[idx].getName());
					System.out.printf("현재 적용된 할인율은 %.2f 입니다.\n", ((Premium)cArr[idx]).getDiscount());
				}
			}
		}
				

////부모를 통해 자식 메서드를 실행
//		for(int i = 0; i <cArr.length; i++) {
//			//프리미엄 고객의 경우 누적구입액을 출력하도로 한다.
//			cArr[i].buy("xxxxxx", (int)(rand.nextInt(100000)+10000) / 10000 * 10000);
//			if(cArr[i] instanceof Premium) { 		//cArr[i]가 가리키는 객체가 Premium 인지 아닌지 확인하는 연산자. 맞으면 true 반환
//				System.out.println("현재까지의 누적구입액 : " + ((Premium)cArr[i]).getPriceTotal());
//			}
//		}

	}

}
