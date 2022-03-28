package exam02;

public class Teacher extends Person {
	
	private int classLevel; 	// 담당 학년
	private int classRoom;	// 담당 반
	private String subject; 	// 담당 과목
	
	public Teacher(String name) {
//		super(); 암묵적으로 자동생성
		super.setName(name);
	}
	
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
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	public String getGender() {
		return super.getGender() + "선생님";
	}

	@Override //Source 메뉴에서 자동생성 가능
	public String toString() {
		return "Teacher [Name()=" + getName() + ", Age()=" + getAge() + ", Gender()=" + getGender()
				+ ", classLevel=" + classLevel + ", classRoom=" + classRoom + ", subject=" + subject + "]";
	}

}
