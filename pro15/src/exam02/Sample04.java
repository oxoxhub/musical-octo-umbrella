package exam02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	//이름이 중복일 때 객체 하나만 남기고 싶을 때
	//이름만 놓고 비교할때 김철수 이름이 두개이고 나이가 다르다면
	//먼저 추가한 객체를 남겨놓고 뒤에 중복되는 값을 삭제한다.
//	@Override
//	public int hashCode() {
//		return Objects.hash(name);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		return Objects.equals(name, other.name);
//	}

	
	//이름 나이가 같은 객체를 하나만 남기고 싶을 때
	//hashCode & equals는 객체는 다르나 그 안에 든 데이터가 같다면 중복으로 판단해준다.
	//그래서 김철수,23은 중복제거가 되어서 하나만 나온다.
	//여기서는 age,name가 중복되는지를 본다
	//이름만 중복으로 체크하고싶다면 Source에서 메서드를 다시 만든다
	//만약 이름은 같고 나이가 다르면 정렬되어 모두 출력해준다.
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
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
		return age == other.age && Objects.equals(name, other.name);
	}
	
	
}

public class Sample04 {

	public static void main(String[] args) {

		Set<Person> pSet = new HashSet<Person>();
		pSet.add(new Person("홍길동",25));
		pSet.add(new Person("김철수",23));
		pSet.add(new Person("김철수",21));
		pSet.add(new Person("박주왕",26));
		
		System.out.println(pSet);
		
	}

}
