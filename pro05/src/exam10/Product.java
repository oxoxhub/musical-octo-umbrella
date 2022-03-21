package exam10;

public class Product {
	
	private String pName = "키보드";
	private int price = 250000;
	private String brand ="X오X드";
	
	public Product() {}
	
	public void information() {
		System.out.println("pName : " + pName);
		System.out.println("price : " + price);
		System.out.println("brand : " + brand);
	}

}
