package me.pedrokaua.loginregister.exception;

public class ImagePathException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Image path error.";
	}
}
