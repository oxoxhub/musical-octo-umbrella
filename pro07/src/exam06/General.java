package exam06;

public class General extends Customer {
	
	public General(String name, int age, char gender) {
		super(name, age, gender);
	}
	
	@Override
	public void buy(String productName, double price) {
		super.buy(productName, price);
		this.setPriceTotal(this.getPriceTotal() + price);
	}
	
}
