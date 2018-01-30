package com.kaishengit.exception;

public class ForbiddenException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ForbiddenException(String message) {
		super(message);
	}
	
	public ForbiddenException(Throwable th) {
		super(th);
	}
	
	public ForbiddenException(String message, Throwable th) {
		super(message,th);
	}
}
