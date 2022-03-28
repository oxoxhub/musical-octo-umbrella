package exam06;

import java.util.Arrays;

import exam05.Grade;

public class StudentList {
	/*
	 * Student 클래스를 배열 형식으로 관리할 수 있게 만드는 클래스
	 * 이 클래스로 다음의 기능을 제공하도록 한다.
	 * 		- 학생 정보를 추가 할 수 있는 기능
	 *				 (반드시 이름, 나이, 학년, 반 정보가 저장되도록 한다.)
	 * 		- 학생 정보를 수정 할 수 있는 기능
	 * 			(학생 이름으로 학년, 반 정보를 수정할 수 있게 한다.)
	 * 		- 학생 정보를 삭제 할 수 있는 기능
	 *			 	(학생 이름 뿐만 아니라 학년 정보로도 삭제할 수 있게 한다.)
	 * 			 예로 3학년에 해당하는 학생 정보를 모두 삭제할 수 있게 하는 기능
	 * 		- 학생 이름으로 학년, 반 정보를 제공하는 기능
	 * 		- 학년 정보로 모든 학생의 이름을 제공하는 기능
	 * 		- 학년, 반 정보로 모든 학생의 이름을 제공하는 기능
	 */
	
	private Student[] sList;
	
	public StudentList() {
		this.sList = new Student[0];
	}
	
	//Student[] sList의 새로운 객체를 만드는 메소드
	public void add(Student student){
		//StudentList 클래스의 멤버인 Student[] sList의 객체를 만든다
		//기존의 sList의 값은 보존하고 배열의 길이는 1씩 늘려간다.
		this.sList = Arrays.copyOf(this.sList, length() + 1);
		//참조값을 매개변수로 받으면 그 참조값을 sList 새로만든 객체배열에 할당한다.
		this.sList[length() - 1] = student;
	}
	
	//메인 메소드에서 매개변수를 보내면 그 인자들로
	//Student 클래스 내의 매개변수가 있는 생성자를 통해 멤버변수들을 초기화한다
	//그럼 메인메소드에서 보낸 인자들로 초기화된 Student 클래스가 만들어진다.
	//만들어진 Student의 클래스를 new로 참조값을 만들어 
	//변수 s에 할당한다.
	public void add(String name, int age, int grade, int group) {
		Student s = new Student(name, age, grade, group);
		this.add(s);
	}
	
	
	// 학생 이름으로 학년, 반 정보를 제공하는 기능	
	public int[] getGradeGroup(String name) {
		int index = findIndex(name);
		if(_validIndex(index)) {
			int[] result = new int[2];
			
			result[0] = getGrade(index);
			result[1] = getGroup(index);
//			result[0] = this.sList[index].getGrade();
//			result[1] = this.sList[index].getGroup();
			
			return result;
		} 
		return null;
	
	}
	
	// 학년 정보로 모든 학생의 이름을 제공하는 기능

	public String[] getTname(int grade) {
		String[] result = new String[0];
		
		for(int i = 0; i < length(); i++) {
			if(this.sList[i].getGrade() == grade) {
				result = Arrays.copyOf(result, result.length +1 );
				result[result.length - 1] = this.sList[i].getName();
			}
		}
		return result;
	}
	
	// 학년, 반 정보로 모든 학생의 이름을 제공하는 기능
	
	public String[] getTname(int grade, int group) {
		String[] result = new String[0];
		
		for(int i = 0; i < length(); i++) {
			if(this.sList[i].getGrade() == grade && this.sList[i].getGroup() == group) {
					result = Arrays.copyOf(result, result.length +1 );
					result[result.length - 1] = this.sList[i].getName();
			}
		}
		return result;
	}
	
	
	/*				- 학생 정보를 삭제 할 수 있는 기능
	 *			 	 (학생 이름 뿐만 아니라 학년 정보로도 삭제할 수 있게 한다.)
	 * 			 예로 3학년에 해당하는 학생 정보를 모두 삭제할 수 있게 하는 기능
	 */
	
	//학생 이름 입력시 해당 학생 정보 삭제하는 기능
	//이름을 입력하면 그 입력된 이름이 저장된 배열의 인덱스를 찾아서
	// _nameRemove 메서드로 입력한 이름이있는 인덱스만 빼고 다시 배열을 만든다
	public void nameRemove(String name) {
		int index = findIndex(name);
		if(_validIndex(index)) {
			 _nameRemove(index);
		}
	}
	
	//학년 입력시 해당 학년의 학생 정보를 모두 삭제하는 기능
	public void gradeRemove(int grade) {
		int idx = 0;
		Student[] temp = new Student[0];
		for(int i = 0; i < length(); i++) {
			if(this.sList[i].getGrade() != grade) {
				temp = Arrays.copyOf(temp, temp.length + 1);
				temp[idx] = this.sList[i];
				idx++;
			}
		}
		this.sList = temp;
	}

	
	//내가 입력한 이름이 index로 바뀌어서 (findIndex 메서드를 통해)
	//그 index를 나머지 인덱스들의 값과 비교해서 같으면 임시배열에 저장 못하고
	//같지 않다면 임시배열에 저장한다
	//그 후 임시배열이 담긴 참조값을 sList에 얕은복사한다.
	private void _nameRemove(int index) {
		int idx = 0;
		Student[] temp = new Student[length() - 1]; //인덱스를 삭제할거라 기존 배열 길이에서 -1을 해야한다.
		for(int i = 0; i < length(); i++) {
			if(i != index) {
				temp[idx++] = this.sList[i];
			}
		}
		this.sList = temp;
	}
	
	
	// 학생 이름으로 학년, 반 정보를 수정할 수 있게 한다.
	//     - 수정 할 학생을 찾아서 학년을 수정 -> 찾을 학생명, 수정할 학년
	//     - 수정 할 학생을 찾아서 반을 수정 -> 찾을 학생명,  수정할 반
	//     - 수정 할 학생을 찾아서 학년과 반을 수정 -> 찾을 학생명, 수정할 학년 , 수정할 반
	
	public void updateGrade(String name, int grade) {
		int idx = this.findIndex(name);
		if(idx >= 0) {
			this.sList[idx].setGrade(grade);
		}
	}
	
	public void updateGroup(String name, int group) {
		int idx = this.findIndex(name);
		if(idx >= 0) {
			this.sList[idx].setGroup(group);
		}
	}
	
	public void update(String name, int grade, int group) {
		int idx = this.findIndex(name);
		if(idx >= 0) {
			this.sList[idx].setGrade(grade);
			this.sList[idx].setGroup(group);
		}
	}
	
	
	//조회
	
	public String getName(int index) {
		if(_validIndex(index)) {
			return this.sList[index].getName();
		}
		return null;
	}
	
	public int getAge(int index) {
		if(_validIndex(index)) {
			return this.sList[index].getAge();
		}
		return 0;
	}
	
	public int getGrade(int index) {
		if(_validIndex(index)) {
			return this.sList[index].getGrade();
		}
		return 0;
	}
	
	public int getGroup(int index) {
		if(_validIndex(index)) {
			return this.sList[index].getGroup();
		}
		return 0;
	}
	
	
	//이름 입력하면 인덱스 찾는 기능
	public int findIndex(String name) {
		for(int i = 0; i < length(); i++) {
			Student data = this.sList[i];
			if(data.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	
	//배열의 길이 
	public int length() {
		return this.sList.length;
	}
	
	//유효한 범위의 인덱스인지 확인하는 메서드
	private boolean _validIndex(int index) {
		return (index >= 0 && index < length());
	}

}
