package exam04;

public class Person {
	
	private String name;
	
	public Person() {}
	
	//pList.add(new Person("곽도운"));
	public Person(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
