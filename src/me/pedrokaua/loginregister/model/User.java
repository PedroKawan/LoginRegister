package me.pedrokaua.loginregister.model;

import java.util.Calendar;

public class User extends Person{

	private String userName, email, password;
	
	public User(String name, String userName, String email, String passoword,
			char gender, Calendar birth) {
		
		super(name, gender, birth);
		this.setUserName(userName);
		this.setEmail(email);
		this.setPassword(passoword);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
