package exam06;

public class StopWatch {
	
	/*
	 * 스탑 워치 프로그램 개발을 위해 사용할 시간 객체를 추상화하여 클래스 다이어그램으로
	 * 만들고 클래스로 정의하시오.
	 * 멤버 변수는 변수명, 접근제한, 타입과 필요한 경우 초기값까지 정의한다.
	 * 메서드(기능)의 경우에는 기능명만 작성.
	 */
	
	private int hour;
	private int minute;
	private int seconds;
	
	//변수의 값을 할당할 때는 setter 
	public void setHour(int h) { 
		hour = h;
	}
	
	//변수에 있는 값을 확인할 때는 getter
	public int getHour() {
		return hour;
	}
	
	public void start() {}
	
	public void stop() {}
	
	public void pause() {}
	
	public void reset() {}
	
	public void record() {}

}
