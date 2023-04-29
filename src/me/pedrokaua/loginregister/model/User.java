package me.pedrokaua.loginregister.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class User extends Person{

	private String userName, email, password;
	
	public User(String name, String userName, char gender, LocalDate birth,
			String email, String passoword) {
		super(name, gender, birth);
		this.setUserName(userName);
		birth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.setEmail(email);
		this.setPassword(passoword);
	}
	
	public User(String email, String passoword) {
		super("void", 'v', LocalDate.now());
		this.setEmail(email);
		this.setPassword(passoword);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password) 
				|| Objects.equals(userName, other.userName);
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
