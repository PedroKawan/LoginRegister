package me.pedrokaua.loginregister.exception;

public class UserAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Error in regex area.";
	}
	
}
