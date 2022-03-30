package exam04;

public class Main {

	public static void main(String[] args) {
		
		Premium p1 = new Premium("홍길동", 35, 'M');
		General n1 = new General("고길동", 45, 'M');
		
		p1.buy("루이비통", 3500000);
		p1.buy("루이비통", 3500000);
		p1.buy("루이비통", 3500000);
		p1.buy("루이비통", 3500000);
		n1.buy("루이비통", 3500000);
		
	}

}
