package exam07;

//부장
public class Director extends DeputyGeneralManager {
	
	/*
	 * 부장은 차장의 자손이라 TeamManager, HeadManager 모두 상속 받는다.
	 */
	
	public Director(String name, int age) {
		super(name, age);
		setSalary(8000);
	}
	
	//조상 클래스의 메서드를 오버라이드하여 재정의한 메서드	
	@Override
	public void bonus(int month) {
		switch(month) {
			case 12:
				double bonus = getSalary() * 0.25;
				System.out.printf("보너스 %,d 원 지급하였습니다.\n", (int)(bonus * 10000));
		}
	}
	
}
