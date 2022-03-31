package exam09;

//인터페이스는 다중 상속이 가능하다.
public abstract class Customer implements Basket, Delivery, Payment {
	private String name;
	private int age;
	private char gender;
	private double priceTotal;
	
	public Customer(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	//추상 메서드
	public abstract void buy(String productName, double price);
	
	
	/*
	 * 인터페이스 클래스를 implements한 클래스를 상속받은 자식 클래스가 인터페이스를 구현해도된다. 
	 * 꼭 implements한 클래스가 하지 않아도 된다. (단, 자손이 구현했다는 전제하에)
	 * 이 클래스(Customer)는 추상 클래스이고 Basket, Delivery, Payment 를 구현하는 클래스인데 Basket 메서드의 일부만 구현하였고
	 * 실제 구현은 이 클래스의 자손(NormalCustomer, PremiumCustomer)들이했다. <- 자손들이 이 클래스를 상속받았기 때문에 가능한 것이다.
	 */
	
	@Override
	public void add(String productName) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void add(String productName, int count) {
		// TODO Auto-generated method stub
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public double getPriceTotal() {
		return this.priceTotal;
	}
	
	public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}
	
}
