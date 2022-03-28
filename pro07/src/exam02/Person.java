package exam02;

import java.util.Objects;

public class Person {
	
	private String name;
	private int age;
	private char gender;
	
	//매개변수 있는 생성자를 만들면 기본 생성자가 없기때문에
	//후손 클래스에서 매개변수가있는 생성자를 만들고
	//super(name);을 적어준다.
//	public Person(String name) {
//		this.name = name;
//	}
	
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
	
	public String getGender() {
		if(gender == 'M') {
			return "남";
		} else {
			return "여";
		}
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}

	@Override //Source 메뉴에서 자동으로 생성 해줄수있다.
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
//	@Override
	//객체의 주소만으로 문자열을 볼수있다
	//모든 클래스의 최상위 클래스는 object
//	public String toString() {
//		return name +  "|" + age;
//	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && gender == other.gender && Objects.equals(name, other.name);
	}
	
	
//	@Override //Source 메뉴에서 자동생성 가능 hashCode and equals
//	public boolean equals(Object obj) {
//		Person p = (Person)obj;		// 캐스팅 -> 다운캐스팅. 객체도 캐스팅이 가능하다(다형성)
//		
//		if(this.name.equals(p.name)) {
//			if(this.age == p.age) {
//				return true;
//			}
//		} 
//			return false;
//	}

}
