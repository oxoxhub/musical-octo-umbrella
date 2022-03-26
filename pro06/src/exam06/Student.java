package exam06;

public class Student {
	/*
	 * 학생 정보를 관리하기 위한 클래스
	 * 	이름 나이, 학년, 반 정보를 관리하는 클래스이다.
	 */
	
	private String name; //이름
	private int age;	//나이
	private int grade;	//학년
	private int group;	//반
	
	public Student() {}
	
	public Student(int grade, int group) {
		this.grade = grade;
		this.group = group;
	}

	public Student(String name, int age, int grade, int group) {
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.group = group;
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	
	
}
