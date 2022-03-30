package exam09;

public class Premium extends Customer {
	private double discount;
	
	
	public Premium(String name, int age, char gender) {
		super(name, age, gender);
	}
	
	public double getDiscount() {
		return discount;
	}


	@Override
	public void buy(String productName, double price) {
		price = _calcDiscount(price);
		this.setPriceTotal(this.getPriceTotal() + price);
		System.out.printf("%s님이 %s을(를) 할인율 %.2f 적용하여 %,.0f원에 구입하였습니다.\n"
				, this.getName(), productName, this.discount, price);
	}
	
	private double _calcDiscount(double price) {
		if(this.getPriceTotal() >= 10000000) {
			this.discount = 0.1;
		} else if(this.getPriceTotal()  >= 5000000) {
			this.discount = 0.05;
		} else if(this.getPriceTotal()  >= 3000000) {
			this.discount = 0.02;
		}
		price = price * (1 - discount);
		return price;
	}

	@Override
	public void refund(String productName, double price) {
		price = _calcDiscount(price);
		System.out.printf("%s님이 %.2f 할인율이 적용된 %s을(를) %,.0f원에 환불하였습니다.", 
				this.getName(),  this.discount, productName, price);
		this.setPriceTotal(this.getPriceTotal() - price);
		
	}
}
