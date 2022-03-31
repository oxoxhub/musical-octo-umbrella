package exam07;

//직원
public abstract class Employee {
	private String name;
	private int age;
	private char gender;
	private int salary;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void payMonth() {
		double pay = (double)getSalary() / 12;
		System.out.printf("월급 %,d 원 지급하였습니다.\n", (int)(pay * 10000));
	}
	
	//추상클래스의 추상메서드
	public abstract void bonus(int month);

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
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
}
