package me.pedrokaua.loginregister.exception;

public class DataRegexException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Data file error.";
	}
	
}
