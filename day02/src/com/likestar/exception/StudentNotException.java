package com.likestar.exception;

public class StudentNotException extends Exception{

	public StudentNotException() {
		super();
	}

	public StudentNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StudentNotException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotException(String message) {
		super(message);
	}

	public StudentNotException(Throwable cause) {
		super(cause);
	}
	
	
}
