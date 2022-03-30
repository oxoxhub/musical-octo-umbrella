package exam09;

public class General extends Customer {
	
	public General(String name, int age, char gender) {
		super(name, age, gender);
	}
	
	@Override
	public void buy(String productName, double price) {
		System.out.printf("%s님이 %s을(를) %,.0f원에 구입하였습니다.\n", this.getName() , productName, price);
		this.setPriceTotal(this.getPriceTotal() + price);
	}

	@Override
	public void refund(String productName, double price) {
		System.out.printf("%s님이 %s을(를) %,.0f원에 환불하였습니다.", this.getName(), productName, price);
		this.setPriceTotal(this.getPriceTotal() - price);
	}
	
}
