package exam02;

import java.util.Arrays;

public class ReportGrade {
	
	private String name; //학생명
	//과목명
	private String[] subjects; //과목 배열
	private double[] grades; //점수 배열
	
	public ReportGrade(String name) {
		//학생명이 주어지면 해당 학생의 성적표를 생성하기 위한 생성자
		this.name = name;
	}
	
	public ReportGrade(String name, String[] subjects) {
		//학생명과 과목배열이 주어지면 해당 학생의 성적표를 생성하기 위한 생성자
		this.name = name;
		this.subjects = subjects;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}

	public double[] getGrades() {
		return grades;
	}

	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	
	public void setGrades(String subject, double grade) {
		int idx = this._findIndex(subject);
		this.grades[idx] = grade;
	}
	
	public double getGrade(String subject) {
		int idx = this._findIndex(subject);
		return this.grades[idx];
	}
	
	public void add(String subject, double grade) {
		int len = this.subjects.length;
		this.subjects = Arrays.copyOf(this.subjects, this.subjects.length+1);
		this.grades = Arrays.copyOf(this.grades, this.grades.length+1);
		
		this.subjects[len] = subject;
		this.grades[len] = grade;
	}
	
	public void remove(String subject) {
		//기본 배열에 저장되어있는 과목 정보와 점수 정보를 삭제.
		int index = this._findIndex(subject);
		
		if(index == -1) {
			System.out.println("해당 과목이 존재하지 않습니다.");
		}
		
		this.remove(index);
		
		//배열에 없는 과목명의 경우. "해당 과목이 존재하지 않습니다." 출력
	}
	
	public void remove(int index) {
		//기본 배열에 저장되어있는 과목 정보와 점수 정보를 삭제.
		//인덱스의 범위를 벗어나는 경우. "인덱스의 범위를 벗어났습니다." 출력
		
		if(index >= this.subjects.length && index < 0) {
			System.out.println("인덱스의 범위를 벗어났습니다.");
			return; //메서드 종료
		}
		
		String[] temp1 = new String[this.subjects.length - 1];
		double[] temp2 = new double[this.grades.length - 1];
		int idx = 0;
		
		for(int i = 0; i < this.subjects.length; i++) {
			if(i != index) {
				temp1[idx] = this.subjects[i];
				temp2[idx] = this.grades[i];
				idx++;
			}
		}
		this.subjects = temp1;
		this.grades = temp2;
	}
	
	public int _findIndex(String subject) {
		int idx = -1;
		for(int i = 0; i <this.subjects.length; i++) {
			String s = this.subjects[i];
			if(subject.equals(s)) {
				idx = i; //동일한 과목명을 찾아서 인덱스 저장
				break;
			}
		}
		return idx;
	}
	
	
}
