package model.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Teacher extends Account {
	
	private Date loginDate = new Date();
	
	public Teacher(String name) {
		setName(name);
		setPassword("1111");
	}
	
	public Teacher(String name, String password) {
		setName(name);
		setPassword(password);
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
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
		String prefix = "TCH_" + s;
		setPassword(prefix);
		
	}

	public String getLoginDateFormat() {
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		return sFormat.format(loginDate);
	}
	
	
	
}
