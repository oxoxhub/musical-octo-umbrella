package model.vo;

import exception.PasswordUnvalidException;

public abstract class Account {
	private String name;
	private String password;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		boolean numberExisted = false;
		boolean lowerExisted = false;
		boolean upperExisted = false;
		
		if(!(password.length() >=4 && password.length() <= 12)){
			throw new PasswordUnvalidException("패스워드의 길이는 4~12자 사이어야 합니다.");
		}
		
		for(int i = 0; i< password.length(); i++) {
			if(password.charAt(i) >=  '0' && password.charAt(i) <= '9'){
				numberExisted = true;
			}if(password.charAt(i) >=  'A' && password.charAt(i) <= 'Z'){
				lowerExisted = true;
			}if(password.charAt(i) >=  'a' && password.charAt(i) <= 'z'){
				upperExisted = true;
			}
		}
		
		if(!(numberExisted && lowerExisted && upperExisted)) {
			throw new PasswordUnvalidException("패스워드는 영문자(대소문자)/숫자 조합으로 이루어져야 합니다.");
		}
		
		this.password = password;
	}
	
	public void ResetPassword() {
		
	}
	
}
