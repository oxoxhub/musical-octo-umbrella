package model.vo;

import java.util.Random;

public class Student extends Account {
	
	private Grade[] grades;
	
	public Student(String name) {
		setName(name);
		setPassword("1111");
	}
	
	public Student(String name, String password) {
		setName(name);
		setPassword(password);
	}

	public Grade[] getGrades() {
		return grades;
	}
	
	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}
	
	@Override
	public void ResetPassword() {
		Random random = new Random();
		
		String dd = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		char[] ran = new char[6];
		String s = "";
		for(int i = 0; i < ran.length; i++) {
			ran[i]  = dd.charAt(random.nextInt(52)+1);
			s += Character.valueOf(ran[i]).toString();
		}
		String prefix = "STD_" + s;
		setPassword(prefix);
	}
	
}
