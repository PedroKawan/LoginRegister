package me.pedrokaua.loginregister.exception;

public class DataFileNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "User already exist";
	}
	
}
