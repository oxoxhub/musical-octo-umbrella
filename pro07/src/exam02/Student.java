package exam02;

public class Student extends Person {
	
	private int classLevel;	//학년
	private int classRoom;	//반
	
	public Student(String name) {
//		super(); 암묵적으로 자동생성 //조상의 기본생성자 이용.
		super.setName(name);
	}
	
	//매개변수 있는 생성자를 만들면 기본 생성자가 없기때문에
	//후손 클래스에서 매개변수가있는 생성자를 만들고
	//super(name);을 적어준다.
//	public Student(String name) {
//		super(name);
//	}
	
	public int getClassLevel() {
		return classLevel;
	}
	
	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}
	
	public int getClassRoom() {
		return classRoom;
	}
	
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	@Override
	public String getGender() {
		return super.getGender() + "학생";
	}

	@Override //Source 메뉴에서 자동생성 가능
	public String toString() {
		return "Student [Name()=" + getName() + ", Age()=" + getAge() + ", Gender()=" + getGender()
				+ ", classLevel=" + classLevel + ", classRoom=" + classRoom + "]";
	}

//	@Override
//	public String toString() {
//		return super.toString() + "|" + classLevel + "|" + classRoom;
//	}

}
